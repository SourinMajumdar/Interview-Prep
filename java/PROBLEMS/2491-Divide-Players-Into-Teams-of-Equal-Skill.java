// Link: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/


// weekly 322, 4 Dec 2022
// Q2


class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        long ans = 0;
        int i = 0, j = n - 1, sum = skill[i] + skill[j];

        while (i <= j) {
            if (skill[i] + skill[j] != sum) {
                return -1;
            }

            ans += (skill[i++] * skill[j--]);
        }

        return ans;
    }
}



class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        long ans = 0;
        int sum = skill[0] + skill[n - 1];

        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - i - 1] != sum) {
                return -1;
            }

            ans += (skill[i] * skill[n - i - 1]);
        }

        return ans;
    }
}


// TC: O(n * logn), SC: O(1)