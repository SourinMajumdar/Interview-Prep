// Link: https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/

// Weekly 314, 9 Oct 2022
// Q1


class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int diff = logs[0][1];
        int finalId = logs[0][0];

        for(int i = 1; i < logs.length; i++){
            int currDiff = logs[i][1] - logs[i - 1][1];

            if(currDiff > diff){
                diff = currDiff;
                finalId = logs[i][0];
            }

            if(currDiff == diff){
                finalId = Math.min(finalId, logs[i][0]);
            }
        }

        return finalId;
    }
}

// TC: O(n), SC: O(1)




class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int l = logs.length;
        for (int i = l - 1; i > 0 ; i--) {
            logs[i][1] -= logs[i - 1][1];
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < l; i++) {
            map.putIfAbsent(logs[i][1], new ArrayList<>());
            map.get(logs[i][1]).add(logs[i][0]);
        }

        return Collections.min(map.get(map.lastKey()));
    }
}

// TC: O(n) + O(n * logk) => O(n * logk) - k is the size of treemap
// TC: O(k) - k is the size of treemap
