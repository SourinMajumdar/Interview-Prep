// Link: https://leetcode.com/problems/concatenated-words/description/

class Solution {
    // globally declare a hashset to store all the words
    private Set<String> set = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // add the words to the set
        for (String w : words) {
            set.add(w);
        }

        // initialise answer arraylist
        List<String> ans = new ArrayList<>();
        // iterate over words[]
        for (String w : words) {
            if (isConcat(w)) {  // if the method returns a true,
                ans.add(w);     // we add the word to answer list
            }
        }

        return ans;
    }

    // this method tells us if the word is a concatenation of other words
    private boolean isConcat(String s) {
        // we will partition the word into 2 words
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i);  // first part
            String suffix = s.substring(i);     // second part
            // if both the parts are present in set means that
            // the original word is a concatenation
            // if the prefix is not in set, we will create the next prefix
            // s = "catsdogcats", we have the prefix "cat" which is not in set
            // so we would make the next prefix "cats", which is present in set
            // we are left with "dogcats" as suffix. It is not present in set
            // (if it were present in set we would have got our answer)
            // Now we would recusively call isConcat() to partition "dogcats" the way we did "catsdogcats"
            // it'll make further partitions of the suffix and check if the partitions are present in set
            if (set.contains(prefix) && (set.contains(suffix) || isConcat(suffix))) {
                return true;    // return true if we find that the word is a concatenation
            }
        }

        // no partitioning could create the word, means no concatenation possible
        return false;   // so return false
    }
}

// TC: O(n * k), SC: O(n)











class Solution {
    private Set<String> set = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String w : words) {
            set.add(w);
        }

        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (isConcat(w)) {
                ans.add(w);
            }
        }

        return ans;
    }

    private boolean isConcat(String s) {
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (set.contains(prefix) && (set.contains(suffix) || isConcat(suffix))) {
                return true;
            }
        }

        return false;
    }
}