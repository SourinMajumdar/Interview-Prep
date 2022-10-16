// Link: https://leetcode.com/problems/sum-of-number-and-its-reverse/

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }

        return false;
    }

    public int reverse(int n) {
        int r = 0;
        while (n != 0) {
            r = r * 10 + n % 10;
            n /= 10;
        }

        return r;
    }
}


// OR

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i < num + 1; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }

        return false;
    }

    public int reverse(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        return Integer.valueOf(sb.reverse().toString());
    }
}


// TC: O(n * k)
// say k is the maximum number of digits in a particular element in nums