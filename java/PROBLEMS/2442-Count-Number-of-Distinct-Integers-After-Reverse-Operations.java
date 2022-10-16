// Link: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/

// Weekly 315, 16 Oct 2022
// Q2

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
            set.add(reverse(i));
        }

        return set.size();
    }

    public int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }
}


class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
            set.add(reverse(i));
        }

        return set.size();
    }

    public int reverse(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        return Integer.valueOf(sb.reverse().toString());
    }
}

// TC: O(n * k)
// say k is the maximum number of digits in a particular element in nums