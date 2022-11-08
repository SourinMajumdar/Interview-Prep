// Link: https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}

// TC: O(1)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}

// TC: O(1)


public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }
}

// TC: O(1)

public class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n).replaceAll("0", "");
        return s.length();
    }
}

// TC: O(N * logN)
// N -> number of bits