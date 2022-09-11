// Link: https://leetcode.com/problems/maximum-performance-of-a-team/
// Solution:
// https://www.youtube.com/watch?v=Y7UTvogADH0 (NeetCode's explanation)
// https://www.youtube.com/watch?v=V-TuDMMf-S4 (Coding Decoded's code)


class Solution {

    // Comibining the data of both the given arrays so as to make it easier to do comparisons
    private class Engineer {
        private int speed;
        private int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engg = new ArrayList<>();    // Will store all the engineers

        for (int i = 0; i < n; i++) {
            engg.add(new Engineer(speed[i], efficiency[i]));
        }

        // sorting the engg list in descending order of their efficiency
        Collections.sort(engg, (a,b) -> b.efficiency - a.efficiency);

        // This priority queue (min heap) will contain engineers chosen to form a team to get the performance
        // min heap will keep slowest engineer at the top, faster ones stay longer in the team
        Queue<Engineer> currTeam = new PriorityQueue<>((a, b) -> a.speed - b.speed);

        long teamSpeed = 0, maxPerformance = 0;


        for (Engineer newHire : engg) {

            if (currTeam.size() == k) {
                Engineer slowGuy = currTeam.poll();     // remove the engineer with slowest speed
                teamSpeed -= slowGuy.speed;             // deducting the removed engineer's speed from the total speed
            }

            currTeam.add(newHire);                      // adding the new engineer to the team (engg list)
            teamSpeed += newHire.speed;                 // adding the new engineer's speed to the total speed

            long newPerformance = teamSpeed * (long) newHire.efficiency;    // getting the current performance
            maxPerformance = Math.max(maxPerformance, newPerformance);      // updating the max performance if greater
        }


        return (int) (maxPerformance % 1000000007);         // returning the way asked to in the problem statement
    }
}


/*

Time complexity:
  - O(n) : To add elements to engg list
  - O(n * logn) : to sort engg list
  - O(n * logk) : adding into min heap n times of size k which will perform heapification taking logk time.

Total Time complexity: O(n) + O(n * logn) + O(n * logk)
OR simply O(n * logn)


Space complexity: O(n + k)
where n is the size of the engg list or given arrays and k is the size of the priority queue

*/