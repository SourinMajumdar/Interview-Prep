// Link: https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
// Solution: https://www.youtube.com/watch?v=3hkyjOshZPw

class Solution {
    public String removeDigit(String number, char digit) {

        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i - 1) == digit) {
                if (number.charAt(i) > number.charAt(i - 1)) {
                    return number.substring(0, i - 1) + number.substring(i);
                }
            }
        }

        int lastIdx = number.lastIndexOf(digit);
        return number.substring(0, lastIdx) + number.substring(lastIdx + 1);
    }
}

// TC: O(n), SC: O(1)