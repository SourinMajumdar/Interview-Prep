// Link: https://leetcode.com/problems/bitwise-ors-of-subarrays/

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int subarrayOR = 0;

            for (int j = i; j < arr.length; j++) {
                set.add(subarrayOR |= arr[j]);
            }
        }

        return set.size();
    }
}

// TC: O(n ^ 2)
// SC: O(w) - where w is the number of unique OR values



class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> prevORs = new HashSet<>();

        for (int i : arr) {
            Set<Integer> currORs = new HashSet<>();
            currORs.add(i);

            for (int j : prevORs) {
                currORs.add(i | j);
            }

            // Iterator<Integer> itr = prevORs.iterator();
            // while (itr.hasNext()) {
            //     currORs.add(i | itr.next());
            // }

            // prevORs.forEach((e) -> {
            //     currORs.add(e | i);
            // });

            prevORs = currORs;
            ans.addAll(prevORs);
        }

        return ans.size();
    }
}

// Time Complexity: O(N * log W) - where N is the length of arr, and W is the maximum size of elements in arr.
// Space Complexity: O(N * logW), the size of the answer.