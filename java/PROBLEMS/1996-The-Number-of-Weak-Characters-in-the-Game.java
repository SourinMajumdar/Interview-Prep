// Link: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
// Solution: https://www.youtube.com/watch?v=cVGCka4wuFo


// By sorting:

/*
Say the given array is: [[5,5], [2,3], [6,3], [3,6], [7,5], [5,6]]
After sorting it'd be : [[2,3], [3,6], [5,6], [5,5], [6,3], [7,5]]
 */

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        int weak = 0;
        int maxDefense = Integer.MIN_VALUE;

        for (int i = properties.length - 1; i >= 0; i--) {
            int currDefense = properties[i][1];
            maxDefense = Math.max(maxDefense, currDefense);

            if (currdefense < maxDefense) weak++;
        }

        return weak;
    }
}

// TC: O(n * logn) + O(n), SC: O(1)

// By sorting, but in the reverse fashion as in the previous approach
// So as to use a for-each loop and make the runtime a bit faster

/*
Say the given array is: [[5,5], [2,3], [6,3], [3,6], [7,5], [5,6]]
After sorting it'd be : [[7,5], [6,3], [5,5], [5,6], [3,6], [2,3]]
*/
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] != b[0]) ? b[0] - a[0] : a[1] - b[1]);
        int weak = 0;
        int maxDefense = Integer.MIN_VALUE;

        for (int[] n : properties) {
            maxDefense = Math.max(maxDefense, n[1]);
            if (n[1] < maxDefense) weak++;
        }

        return weak;
    }
}

// TC: O(n * logn) + O(n), SC: O(1)