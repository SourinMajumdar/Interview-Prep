// Link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// https://www.youtube.com/watch?v=ZOP43iB_E_8

class Solution {
    private class Job {
        private int startTime;
        private int endTime;
        private int profit;

        public Job(int s, int e, int p) {
            this.startTime = s;
            this.endTime = e;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobList = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            jobList.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobList, (a, b) -> a.endTime - b.endTime);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        int ans = 0;

        for (Job currJob : jobList) {
            int lastEndTime = map.floorKey(currJob.startTime);
            int lastEndTimeMaxProfit = map.get(lastEndTime);
            ans = Math.max(ans, lastEndTimeMaxProfit + currJob.profit);
            map.put(currJob.endTime, ans);
        }

        return ans;
    }
}

// TC: O(n * logn), SC: O(n)