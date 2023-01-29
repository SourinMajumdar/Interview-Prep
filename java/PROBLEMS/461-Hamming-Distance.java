// Link: https://leetcode.com/problems/hamming-distance/

// x & 1 will give us the last bit of x
// y & 1 will give us the last bit of y

// If they are unequal, increment count
// Right shift x and y
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            y >>= 1;
            x >>= 1;
        }

        return count;
    }
}

// TC: O(32) => O(1)
// SC: O(1)



// XOR of them will give 1, if they are unequal
// otherwise it'll give 0
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            count += (x & 1) ^ (y & 1);
            y >>= 1;
            x >>= 1;
        }

        return count;
    }
}

// TC: O(32) => O(1)
// SC: O(1)


class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

// TC: O(1), SC: O(1)