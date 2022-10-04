/*
Problem link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
Solution: https://www.youtube.com/watch?v=xnwoEISwhrY
 */

// Brute force approach - TC: O(N^2), SC: O(N)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i<candies.length; ++i){
            boolean isGreater = true;
            for (int j = 0; j<candies.length; ++j){
                if(candies[i] + extraCandies < candies[j]){
                    isGreater = false;
                    break;
                }
            }
            ans.add(isGreater);
        }
        return ans;
    }
}


// Optimised approach - TC: 0(N), SC: O(N)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) max = Math.max(i, max);

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;
            ans.add(candies[i] >= max);
        }

        return ans;
    }
}