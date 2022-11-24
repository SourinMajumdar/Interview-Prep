// Link: https://leetcode.com/problems/counting-bits/

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}

// TC: O(n * logn), SC: O(n)


class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        if (n == 0) return 0;
        return (n & 1) + countSetBits(n >> 1);
    }
}

// TC: O(n * logn), SC: O(logn)


// Brain Kernighan's algo

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
}

// TC: O(n * logn), SC: O(n)


// Brian Kernighan's algo recursive

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
}

// TC: O(n * logn), SC: O(logn)


// Checking each bit in a number:

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        int count = 0;

        for (int i = 0; i < 4 * 8; i++) {
            if ((n & (1 << i)) != 0)
                count++;
        }

        return count;
    }
}

// TC: O(n), SC: O(n)


// using Integer.bitCount():

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];
        setBits[0] = 0;

        for (int i = 1; i <= n; i++) {
            setBits[i] = (i % 2 == 0)? setBits[i / 2] : setBits[i - 1] + 1;
        }

        return setBits;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];
        setBits[0] = 0;

        for (int i = 1; i <= n; i++) {
            setBits[i] = countSetBits(i);
        }

        return setBits;
    }

    public int countSetBits(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') count++;
        }

        return count;
    }
}

// TC: O(n * logn), SC: O(n)



class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];
        setBits[0] = 0;

        for (int i = 1; i <= n; i++) {
            setBits[i] = countSetBits(i);
        }

        return setBits;
    }

    public int countSetBits(int n) {
        String s = Integer.toBinaryString(n).replaceAll("0", "");
        return s.length();
    }
}

// TC: O(n^2 * logn), SC: O(n)



// Using lookup table
class Solution {
    private int[] bitsSetTable256 = new int[256];

    public void initialize() {
        bitsSetTable256[0] = 0;

        for (int i = 0; i < 256; i++) {
            bitsSetTable256[i] = (i & 1) + bitsSetTable256[i / 2];
        }
    }

    public int[] countBits(int n) {
        initialize();
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countSetBits(i);
        }

        return ans;
    }

    public int countSetBits(int n) {
        return
            bitsSetTable256[n & 0xff] +
            bitsSetTable256[(n >> 8) & 0xff] +
            bitsSetTable256[(n >> 16) & 0xff] +
            bitsSetTable256[n >> 24]
        ;
    }
}

// TC: O(n), SC: O(n)