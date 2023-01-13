// Link: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/


// The idea is the find the minimum number of whites to exist in a window
// we will turn those whites to blacks

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, right = 0;                  // initialise pointers
        int whites = 0;                     // to record number of whites in the window
        int minWhites = blocks.length();    // to record minimum number of whites in a window

        // place the starting window (from 0 to k-1)
        // also count the number of whites in the starting window
        while (right < k) {
            if (blocks.charAt(right++) == 'W') {
                whites++;
            }
        }
        // update minWhites with whatever we have achieved in the starting window
        minWhites = Math.min(minWhites, whites);

        // start sliding the window
        while (right < blocks.length()) {
            // Because we will move forward, we will have to
            // discard what we have at the leftmost end and acquire from the rightmost end
            if (blocks.charAt(left++) == 'W') {     // if leftmost end has a W
                whites--;                           // discard
            }
            if (blocks.charAt(right++) == 'W') {    // if rightmost end has a W
                whites++;                           // acquire
            }
            minWhites = Math.min(minWhites, whites);    // update minWhites
        }

        return minWhites;
    }
}

// TC: O(n), SC: O(1)