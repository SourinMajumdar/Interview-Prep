// Link: https://leetcode.com/problems/find-the-difference/


// 1. Solution: https://www.youtube.com/watch?v=Ds4Kvd_xn4w

class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c)) {
                return c;
            }

            map.put(c, map.get(c) - 1);
        }

        return '!';
    }
}

// TC: O(n); SC: O(n)



// Second approach:
// To get the sum of the ASCII values of all letters present in strings s and t and store them separately
// And return the difference of the sums type-cast to char which will give the letter that was added extra
// (Because the difference would itself be an ASCII value)

class Solution {
    public char findTheDifference(String s, String t) {
        int sum_s = 0, sum_t = 0;

        for (int i =0; i < s.length(); i++) {
            sum_s += s.charAt(i);
        }

        for (int i =0; i < t.length(); i++) {
            sum_t += t.charAt(i);
        }

        return (char)(sum_t - sum_s);
    }
}

// TC: O(n), SC: O(1)