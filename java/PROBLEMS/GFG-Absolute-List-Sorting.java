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


// TC: O(n), SC: O(n)




