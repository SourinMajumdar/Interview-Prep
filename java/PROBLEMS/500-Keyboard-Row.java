// Link: https://leetcode.com/problems/keyboard-row/description/

class Solution {
    public String[] findWords(String[] words) {
        // Sets containing characters of each keyboard row
        Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Set<Character> row2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

        List<String> ans = new ArrayList<>();   // it will store the passing strings
        for (String s: words) {
            // we will now see if all characters in the word are contained in first row
            boolean rowOneContainsAll = true;
            for (char c : s.toCharArray()) {
                // if first row doesn't contain the character
                if (!row1.contains(Character.toLowerCase(c))) {
                    rowOneContainsAll = false;
                    break;
                }
            }

            // if first row contains all the characters
            if (rowOneContainsAll) {
                ans.add(s);     // add the word to answer list
                continue;       // continue the loop
            }

            // THE WORD WAS NOT FOUND IN THE FIRST ROW
            // we will now see if all characters in the word are contained in second row
            boolean rowTwoContainsAll = true;
            for (char c : s.toCharArray()) {
                // if second row doesn't contain the character
                if (!row2.contains(Character.toLowerCase(c))) {
                    rowTwoContainsAll = false;
                    break;
                }
            }

            // if second row contains all the characters
            if (rowTwoContainsAll) {
                ans.add(s);     // add the word to answer list
                continue;       // continue the loop
            }

            // THE WORD WAS NOT FOUND IN THE SECOND ROW
            // we will now see if all characters in the word are contained in third row
            boolean rowThreeContainsAll = true;
            for (char c : s.toCharArray()) {
                // if third row doesn't contain the character
                if (!row3.contains(Character.toLowerCase(c))) {
                    rowThreeContainsAll = false;
                    break;
                }
            }

            // if third row contains all the characters
            if (rowThreeContainsAll) {
                ans.add(s);     // add the word to answer list
            }

            // If the word hasn't been found in any of the specific rows at all,
            // we will move to the next word
        }

        // Returning the answer arraylist an array of strings
        return ans.toArray(new String[ans.size()]);
    }
}

// TC: O(n * k), since k is very small (<= 20) we can amortize it to O(n)
// SC: O(n) - answer array might store all the given strings