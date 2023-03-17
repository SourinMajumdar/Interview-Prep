// Link: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/

class Solution {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (n != freq[i]) {
                return false;
            }
        }

        return true;
    }
}


class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : num.toCharArray()) {
            int n = c - '0';
            map.put(n, 1 + map.getOrDefault(n, 0));
        }

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (n != map.getOrDefault(i, 0)) {
                return false;
            }
        }

        return true;
    }
}

// n <=10
// TC = SC = O(1)