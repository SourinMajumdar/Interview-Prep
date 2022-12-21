// Link: https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1


class Solution {
    Node sortList(Node head) {
        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        Node ans = new Node(-1);
        temp = ans;
        for (int i : list) {
            temp.next = new Node(i);
            temp = temp.next;
        }

        temp.next = null;

        return ans.next;
    }
}


class Solution {
    Node sortList(Node head) {
        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        for (int i : list) {
            temp.data = i;
            temp = temp.next;
        }

        return head;
    }
}


// TC: O(n * logn), SC: O(n)




class Solution {
    Node sortList(Node head) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            if (temp.data < 0) {
                neg.add(temp.data);
            }
            else {
                pos.add(temp.data);
            }
            temp = temp.next;
        }

        for (int i = 0, j = neg.size() - 1; i < j; i++, j--) {
            int tmp = neg.get(i);
            neg.set(i, neg.get(j));
            neg.set(j, tmp);
        }

        temp = head;
        for (int i : neg) {
            temp.data = i;
            temp = temp.next;
        }
        for (int i : pos) {
            temp.data = i;
            temp = temp.next;
        }

        return head;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    Node sortList(Node head) {
        Node curr = head.next, prev = head;

        while (curr != null) {
            if (prev.data > curr.data) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return head;
    }
}

// TC: O(n), SC: O(1)
