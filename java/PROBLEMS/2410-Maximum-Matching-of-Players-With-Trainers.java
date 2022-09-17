// Link: https://leetcode.com/problems/maximum-matching-of-players-with-trainers/

// Bi-Weekly 87 (17 September 2022)
// Q2

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        // We create an arraylist for trainers so that we can remove elements from it
        List<Integer> tList = new ArrayList<>();
        for (int i : trainers) tList.add(i);       // adding the elements from trainers[]

        int matchCount = 0;

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < tList.size(); j++) {
                if (players[i] <= tList.get(j)) {   // If yes, we get a match
                    matchCount++;
                    tList.remove(j);                // We remove that element because it can't be used more than once
                    break;                          // We break out because a match has been found and we don't want to look further in tList
                }
            }
        }

        return matchCount;
    }
}

// TC: O(n*logn + m*logm) + O(m) + O(m * n)
// SC: O(m)

/*
We could use the same given trainers array and when an element forms a match we could simply put a 0 or -1 in that place
so that when we encounter 0 or -1 we would simply skip it. But it gives a TLE.

But if we use an arraylist, we remove the element after it forms a match,
therefore its length decreases and the inner for loop has to run lesser and lesser in worst case after every match is found.
Therefore we don't hit a TLE.
 */




class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, matchCount = 0;

        while (i < players.length && j < trainers.length) {

            if (players[i] <= trainers[j]) {    // If yes, we get a match, we move to next index in both arrays
                matchCount++;                   // because the current indices has been used and can't be used again
                i++; j++;
            }
            else j++;                           // If not a match, we check if next element in trainers[] makes a match
        }

        return matchCount;
    }
}

// TC: O(n*logn + m*logn) + O(m + n)
// SC: O(1)