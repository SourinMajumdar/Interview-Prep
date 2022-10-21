// Link: https://leetcode.com/problems/next-greater-element-i/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        int[] foundIdx = new int[n1];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) foundIdx[i] = j;
            }
        }

        int[] ans = new int[n1];
        int idx = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = foundIdx[i] + 1; j < n2; j++) {
                if (nums2[j] > nums2[foundIdx[i]]) {
                    ans[i] = nums2[j];
                    break;
                }
            }

            if (ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }
}

// TC: O(n * m), SC: O(n)




class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }

            stack.push(n);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}


// TC: O(n + m), SC: O(n + m)
