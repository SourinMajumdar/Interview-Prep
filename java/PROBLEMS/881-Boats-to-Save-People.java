// Link: https://leetcode.com/problems/boats-to-save-people/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numberOfBoats = 0;
        int i = 0, j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++; j--;
            }
            else j--;

            numberOfBoats++;
        }

        return numberOfBoats;
    }
}

// TC: O(n * logn), SC: O(1)