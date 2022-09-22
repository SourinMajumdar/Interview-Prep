// Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/

// https://www.youtube.com/watch?v=99Gk-d-vHo8

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            StringBuilder rev = new StringBuilder(word).reverse();
            ans.append(rev + " ");
        }

        ans.setLength(ans.length() - 1); // remove the last whitespace
        return ans.toString();
    }
}

// TC: O(n + n) => O(n)
// SC: O(n)


// https://www.youtube.com/watch?v=UNqDFKZOevU

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }

            if (i == chars.length - 1) {
                reverse(chars, start, i);
            }
        }

        return new String(chars);
    }

    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}

// TC: O(n + n) => O(n)
// SC: O(n)