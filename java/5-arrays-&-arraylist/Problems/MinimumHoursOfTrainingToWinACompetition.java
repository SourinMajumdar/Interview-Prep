// Link: https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/


// Weekly Contest 307, 21 Aug'22
// Q1

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int n = energy.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (initialEnergy <= energy[i]) {
                int tempEnergy = energy[i] + 1 - initialEnergy;
                ans += tempEnergy;
                initialEnergy += tempEnergy;
            }

            if (initialExperience <= experience[i]) {
                int tempExperience = experience[i] + 1 - initialExperience;
                ans += tempExperience;
                initialExperience += tempExperience;
            }

            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)