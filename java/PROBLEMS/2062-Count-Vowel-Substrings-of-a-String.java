// Link: https://leetcode.com/problems/count-vowel-substrings-of-a-string/

class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> set;
        int count = 0;

        for (int i = 0; i < word.length() - 4; i++) {
            set = new HashSet<>();

            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);

                if (!isVowel(c)) break;

                set.add(c);
                if (set.size() == 5) count++;
            }
        }

        return count;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

// TC: O(n ^ 2), SC: O(1)


// Sliding window
class Solution {
    public int countVowelSubstrings(String word) {
        return atMostKVowels(word, 5) - atMostKVowels(word, 4);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    int atMostKVowels(String s, int k) {
        int i = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            // consonant encountered
            if (!isVowel(c)) {
                vowelMap.clear();     // clear the map coz new substring will start
                i = j + 1;
                continue;
            }

            vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);

            while(vowelMap.size() > k) {
                vowelMap.put(s.charAt(i), vowelMap.get(s.charAt(i)) - 1);
                if (vowelMap.get(s.charAt(i)) == 0) {
                    vowelMap.remove(s.charAt(i));
                }

                i++;
            }

            count += (j - i + 1);
        }

        return count;
    }
}

// TC: O(n), SC: O(1)
