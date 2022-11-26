// Link: https://leetcode.com/problems/add-strings/
// https://www.youtube.com/watch?v=_Qp-CTzat50&t=296s

import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.add(b).toString();
    }
}


class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) sum += (num1.charAt(i--) - '0');
            if (j >= 0) sum += (num2.charAt(j--) - '0');

            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}

// TC: O(max(m, n)), SC: O(max(m, n))