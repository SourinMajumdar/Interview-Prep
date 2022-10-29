// Link: https://leetcode.com/problems/words-within-two-edits-of-dictionary/

// biweekly 90, 29 oct 2022
// Q2

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++){
            String s = queries[i];

            for (int j = 0; j < dictionary.length; j++){
                String str = dictionary[j];
                int diff = 0;

                for(int k = 0; k < str.length(); k++){
                    if (str.charAt(k) != s.charAt(k)) {
                        diff++;
                    }
                }

                if (diff <= 2) {
                    ans.add(s);
                    break;
                }
            }
        }

        return ans;
    }
}

// TC: O(n ^ 2), SC: O(1) - ignoring the output array