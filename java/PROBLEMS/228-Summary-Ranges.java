// Link: https://leetcode.com/problems/summary-ranges/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();   // initialise answer arraylist
        if (nums.length == 0) { // if nums is empty
            return ans;         // return empty arraylist
        }

        // assume the start and ends as the first element of nums
        int start = nums[0], end = nums[0];
        // we will iterate over nums, if the number is adjacent/consecutive
        // to 'end', we will update 'end'
        for (int n : nums) {
            // skip the first element of nums
            // we need to check from the second element of nums
            if (n == start) {
                continue;
            }
            // if say end is 6, and we see 7, end will be updated to 7
            else if (n == end + 1) {
                end = n;
            }
            // if we lose the consecutiveness, we will push the interval obtained so far
            else {
                // say start is 2 and end is 7, so we will add "2->7"
                // but say if we only have 2, i.e. no consecutiveness to both side of start/end
                // we will insert 2 only (start or end, start and end will be equal in that case
                String interval = (start != end)?
                (start + "->" + end) : (end + "");
                ans.add(interval);  // add the interval
                // we will begin afresh from the new value and iterate further to get more intervals
                start = end = n;
            }
        }

        // we will be left with a interval after the iteration is finished
        // so we will add that interval too
        String interval = (start != end)?
        (start + "->" + end) : (end + "");
        ans.add(interval);  // add the interval

        return ans;     // return the answer arraylist
    }
}

// TC: O(n), SC: O(n)




class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        int start = nums[0], end = nums[0];
        for (int n : nums) {
            if (n == start) {
                continue;
            } else if (n == end + 1) {
                end = n;
            } else {
                String interval = (start != end)?
                (start + "->" + end) : (end + "");
                ans.add(interval);
                start = end = n;
            }
        }

        String interval = (start != end)?
        (start + "->" + end) : (end + "");
        ans.add(interval);

        return ans;
    }
}