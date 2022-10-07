/*
Problem link: https://leetcode.com/problems/count-items-matching-a-rule/
Solution: https://www.youtube.com/watch?v=PzuOZ17ubIs
 */

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        if(ruleKey.equals("type")){
            for(int i = 0; i<items.size(); ++i){
                if(items.get(i).get(0).equals(ruleValue)) {
                    ans++;
                }
            }

        } else if (ruleKey.equals("color")){
            for(int i = 0; i<items.size(); ++i){
                if(items.get(i).get(1).equals(ruleValue)) {
                    ans++;
                }
            }

        // ruleKey.equals("name")
        } else {
            for(int i = 0; i<items.size(); ++i){
                if(items.get(i).get(2).equals(ruleValue)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}


class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(getRuleKey(ruleKey)).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

    public int getRuleKey(String ruleKey) {
        if (ruleKey.equals("type")) return 0;
        else if (ruleKey.equals("color")) return 1;
        return 2;
    }
}


// Time complexity: O(N)
// Space complexity: O(1)