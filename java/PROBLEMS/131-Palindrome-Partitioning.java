// Link: https://leetcode.com/problems/palindrome-partitioning/submissions/
// Video: https://www.youtube.com/watch?v=WBgsABoClE0

class Solution {
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        help(s, 0, new ArrayList<>());
        return ans;
    }

    private void help(String s, int idx, List<String> currParts) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(currParts));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                currParts.add(s.substring(idx, i + 1));
                help(s, i + 1, currParts);
                currParts.remove(currParts.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}

/*
Time Complexity: O(2^n * k *n/2)

Reason: O(2^n) to generate every substring and O(n/2) to check if the substring generated is a palindrome.
O(k) is for inserting the palindromes in another data structure, where k is the average length of the palindrome list.

-----------------------------------------------------------------------------------------------------------------------

Space Complexity: O(k * x)

Reason: The space complexity can vary depending upon the length of the answer.
k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer.
The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
 */