// Link: https://leetcode.com/problems/palindrome-pairs/

// https://youtu.be/ewNE1UbjmJ8

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // Empty string case
        if (map.containsKey("")) {
            Integer blankIdx = map.get("");

            for (int i = 0; i < words.length; i++) {
                if (i != blankIdx && isPalindrome(words[i])) {
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        // Reflection case
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            Integer revIdx = map.get(rev);
            if (revIdx != null && revIdx != i) {
                res.add(Arrays.asList(i, revIdx));
            }
        }

        // Tricky case
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                String left = cur.substring(0, cut);
                String right = cur.substring(cut);

                if (isPalindrome(left)){
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedRight)){
                        List<Integer> temp = new ArrayList();
                        temp.add(map.get(reversedRight)); temp.add(i);
                        res.add(temp);
                    }
                }

                if (isPalindrome(right)){
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reversedLeft)){
                        List<Integer> temp = new ArrayList();
                        temp.add(i); temp.add(map.get(reversedLeft));
                        res.add(temp);
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n * k^2), SC: O(n)

// https://www.youtube.com/watch?v=C0p5J1KJ8Zk
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
            set.add(words[i].length());
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = words[i].length();

            if (len == 1) {
                if (map.containsKey("")) {
                    result.add(Arrays.asList(i, map.get("")));
                    result.add(Arrays.asList(map.get(""), i));
                }
                continue;
            }

            String rev = new StringBuilder(words[i]).reverse().toString();

            if (map.containsKey(rev) && map.get(rev) != i) {
                result.add(Arrays.asList(i, map.get(rev)));
            }

            for (Integer k : set) {
                if (k == len) break;

                if (isPalindrome(rev, 0, len - 1 - k)) {
                    String s1 = rev.substring(len - k);
                    if (map.containsKey(s1)) {
                        result.add(Arrays.asList(i, map.get(s1)));
                    }
                }

                if (isPalindrome(rev, k, len - 1)) {
                    String s2 = rev.substring(0, k);
                    if (map.containsKey(s2)) {
                        result.add(Arrays.asList(map.get(s2), i));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

// TC: O((n * log(n)) + (n * k^2))
// SC: O(2n) => O(n)


