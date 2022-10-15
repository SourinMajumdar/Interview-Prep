// Link: https://leetcode.com/problems/string-compression/

// Solution: https://youtu.be/6W1MDK7nPZs


class Solution {
    public int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        ans.append(chars[0]);

        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            }
            else {
                if (count > 1) {
                    ans.append(count);
                    count = 1;
                }
                ans.append(chars[i]);
            }
        }

        if (count > 1) {
            ans.append(count);
            count = 1;
        }

        // modifying the input array
        int i = 0;
        for (char c : ans.toString().toCharArray()) {
            chars[i++] = c;
        }

        return ans.length();
    }
}

// TC: O(n), SC: O(1)


// https://www.youtube.com/watch?v=IhJgguNiYYk

// In-place

class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            int j = i;

            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            chars[index++] = chars[i];

            if (j - i > 1) {
                String count = j - i + "";

                for (char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }
}

// TC: O(n), SC: O(1)


