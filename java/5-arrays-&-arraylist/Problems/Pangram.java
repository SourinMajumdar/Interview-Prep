/*

LEETCODE:
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true

Example 2:
Input: sentence = "leetcode"
Output: false

Problem link: https://leetcode.com/problems/check-if-the-sentence-is-pangram/

 */

class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean allLettersPresent = true;

        for(char ch='a';ch<='z';ch++){
            if (!sentence.contains(String.valueOf(ch))) {
                allLettersPresent = false;
                break;
            }
        }
        return allLettersPresent;
    }
}