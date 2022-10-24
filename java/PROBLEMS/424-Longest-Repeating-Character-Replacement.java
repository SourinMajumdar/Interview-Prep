// link: https://leetcode.com/problems/longest-repeating-character-replacement/

// Solution: https://www.youtube.com/watch?v=EF_6AOeHuBI


class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0;

        int maxLen = 0, mostFreq = 0;

        while (right < s.length()) {
            // start acquiring
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(arr[right]));

            int canBeReplaced = (right - left + 1) - mostFreq;

            // release from the left
            if (canBeReplaced > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        int left = 0, right = 0;

        int maxLen = 0, mostFreq = 0;

        while (right < s.length()) {
            mostFreq = Math.max(mostFreq, ++freq[arr[right] - 'A']);
            int canBeReplaced = (right - left + 1) - mostFreq;

            if (canBeReplaced > k) {
                freq[arr[left++] - 'A']--;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}

// TC: O(n), SC: O(n)