// Link: https://leetcode.com/problems/largest-number/
// Solution: https://www.youtube.com/watch?v=q_biivSGbV0

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder str = new StringBuilder();
        for (String s : numsStr) str.append(s);

        String res = str.toString();

        return res.startsWith("0") ? "0" : res;
    }
}

// TC: O(n) + O(n * logn) + O(n) => O(n * logn)
// SC: O(n)


// OR


class Solution {
    public String largestNumber(int[] nums) {
        String res = Arrays.stream(nums)
                    .mapToObj(String :: valueOf)
                    .sorted((a, b) -> (b + a).compareTo(a + b))
                    .reduce((a, b) -> a + b)
                    .get();

        return res.startsWith("0") ? "0" : res;
    }
}