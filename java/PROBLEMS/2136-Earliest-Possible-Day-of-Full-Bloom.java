// Link: https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
// https://www.youtube.com/watch?v=aeKAMmZjvb4


class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Seed> plants = new ArrayList<>();
        int n = plantTime.length;

        for (int i = 0; i < n; i++) {
            plants.add(new Seed(plantTime[i], growTime[i]));
        }

        Collections.sort(plants, (a, b) -> b.growTime - a.growTime);

        int time = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            time += plants.get(i).plantTime;
            max = Math.max(max, time + plants.get(i).growTime);
        }

        return max;
    }

    private class Seed {
        int plantTime;
        int growTime;

        public Seed (int p, int g) {
            this.plantTime = p;
            this.growTime = g;
        }
    }
}

// TC: O(2 * n) + O(n * logn) => O(n * logn)
// SC: O(n)


class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] plants = new int[n][2];

        for (int i = 0; i < n; i++) {
            plants[i][0] = plantTime[i];
            plants[i][1] = growTime[i];
        }

        Arrays.sort(plants, (a, b) -> b[1] - a[1]);

        int time = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            time += plants[i][0];
            max = Math.max(max, time + plants[i][1]);
        }

        return max;
    }
}

// TC: O(2 * n) + O(n * logn) => O(n * logn)
// SC: O(n)