// Link: https://leetcode.com/problems/add-binary/
// https://www.youtube.com/watch?v=tRpusgdZxrE&t=107s


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b. length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) sum += (a.charAt(i--) - '0');
            if (j >= 0) sum += (b.charAt(j--) - '0');

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}

// TC: O(max(m, n)), SC: O(max(m, n))


import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        return x.add(y).toString(2);
    }
}