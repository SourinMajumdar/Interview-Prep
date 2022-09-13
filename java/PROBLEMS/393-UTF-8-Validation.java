// Link: https://leetcode.com/problems/utf-8-validation/solution/
// Solution: https://www.youtube.com/watch?v=3zyxpFPKkEU

/*
    1 byte = 8 bits
    ---------------

     Number of Bytes   |        UTF-8 Octet Sequence
                       |              (binary)
     ------------------+-----------------------------------------
            1          |   0xxxxxxx
            2          |   110xxxxx 10xxxxxx
            3          |   1110xxxx 10xxxxxx 10xxxxxx
            4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
*/

class Solution {
    public boolean validUtf8(int[] data) {
        int remBytes = 0;

        for (int n : data) {
            if (remBytes == 0) {
                if (n >> 7 == 0b0) remBytes = 0;
                else if (n >> 5 == 0b110) remBytes = 1;
                else if (n >> 4 == 0b1110) remBytes = 2;
                else if (n >> 3 == 0b11110) remBytes = 3;
                else return false;
            } else {
                if (n >> 6 == 0b10) remBytes--;
                else return false;
            }
        }

        return remBytes == 0;
    }
}

// TC: O(n) -> We iterate over the array
// SC: O(1) -> No extra space used