// Link: https://leetcode.com/problems/best-team-with-no-conflicts/description/

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        if (n == 1) {
            return scores[0];
        }

        int[][] team = new int[n][2];
        for (int i = 0; i < n; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }

        Arrays.sort(team,
            (a, b) -> (a[0] == b[0])? a[1] - b[1] : a[0] - b[0]
        );

        int[] dp = new int[n];
        int maxOverallScore = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = team[i][1];
            for (int j = 0; j < i; j++) {
                if (team[i][1] >= team[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + team[i][1]);
                }
            }
            maxOverallScore = Math.max(dp[i], maxOverallScore);
        }

        return maxOverallScore;
    }
}

// TC: O(n) + O(n * logn) + O(n^2)
// SC: O(3n) => O(n)