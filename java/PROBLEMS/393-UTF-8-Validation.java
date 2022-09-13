// Link: https://leetcode.com/problems/utf-8-validation/solution/
// Solution: https://www.youtube.com/watch?v=3zyxpFPKkEU

/*
    1 byte = 8 bits
    ---------------

     Number of Bytes   |        UTF-8 Octet Sequence
                       |              (binary)
     ------------------+-----------------------------------------
 a)         1          |   0xxxxxxx
 b)         2          |   110xxxxx 10xxxxxx
 c)         3          |   1110xxxx 10xxxxxx 10xxxxxx
 d)         4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
                           |______| |_______|________|________|
                           1st Byte       Remaining Bytes
*/

class Solution {
    public boolean validUtf8(int[] data) {
        int remBytes = 0;   // Remaining bytes after the 1st byte

        for (int n : data) {

            if (remBytes == 0) {
                if (n >> 7 == 0b0) remBytes = 0;            // 1st byte of 1 length char (0xxxxxxx)
                else if (n >> 5 == 0b110) remBytes = 1;     // 1st byte of 2 length char (110xxxxx 10xxxxxx)
                else if (n >> 4 == 0b1110) remBytes = 2;    // 1st byte of 3 length char (1110xxxx 10xxxxxx 10xxxxxx)
                else if (n >> 3 == 0b11110) remBytes = 3;   // 1st byte of 4 length char (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
                else return false;                          // NOTA

            } else {                                        // if more than 1 byte, we check if the rest start with 10
                if (n >> 6 == 0b10) remBytes--;             // if yes, we decrease remaining bytes
                else return false;                          // If not, sequence not valid
            }
        }

        return remBytes == 0;       // At the end if there are no remening bytes, sequence is valid.
    }
}

// TC: O(n) -> We iterate over the array
// SC: O(1) -> No extra space used