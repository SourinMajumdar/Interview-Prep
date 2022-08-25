// Link: https://leetcode.com/problems/ransom-note/

// 1. Using 2 HashMaps
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransom = new HashMap<>();
        Map<Character, Integer> mag = new HashMap<>();

        // ransomNote letters and their count stored in 1st hashtable
        for (char c : ransomNote.toCharArray()) {
            ransom.put(c, ransom.getOrDefault(c, 0) + 1);
        }

        // magazine letters and their count stored in 2nd hashtable
        for (char c : magazine.toCharArray()) {
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        }


        /*

        For every map in ransom, Check:

        - if a letter in ransom is present in magazine
          (if not present, then ransomNote can't be formed)

        - if a letter count is greater in ransom than in magazine
          (if greater, magazine doesn't have enough letters to form ransomNote)

          Hence return false (if either condition is true)
          Otherwise return true.

        */

        for (Map.Entry<Character, Integer> entry : ransom.entrySet()) {
            char c = entry.getKey();
            if (!mag.containsKey(c) || ransom.get(c) > mag.get(c)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(m + n), SC: O(m + n)


// 1. Using 1 HashMap

/*
     We create a hashmap with all letters and their counts in magazine
     We iterate over ransomNote and check if the letter is present in hashmap
        - if yes, we decrease its count by 1.
        - If not, then direcly return false.
        - If the letter count <= 0, means the letter count in ransomNote is > count in magazine => return false
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            count.put(c , count.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!count.containsKey(c) || count.get(c) <= 0) {
                return false;
            }
            count.put(c, count.get(c) - 1);
        }

        return true;
    }
}

// TC: O(m + n), SC: O(m)


// m -> Length of the magazine string
// n -> Length of the ransomNote string