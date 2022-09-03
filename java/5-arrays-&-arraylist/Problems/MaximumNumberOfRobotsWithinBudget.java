class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int i= 0, j = 0;
        long sum = 0, totalCost = 0;
        int max = Integer.MIN_VALUE;
        int ans = 0, robo = 0;

        while(i < n && j < n){

            sum += runningCosts[j];
            max = Math.max(max, chargeTimes[j]);
            robo++;
            totalCost = max + robo * sum;
            j++;

            if (totalCost > budget){
                sum -= runningCosts[i];
                max = 0;
                i++;
                for(int k = i; k < j; k++){
                    max = Math.max(max, chargeTimes[k]);
                }
                robo--;
            }

            ans = Math.max(ans, robo);
        }

        return ans;
    }
}