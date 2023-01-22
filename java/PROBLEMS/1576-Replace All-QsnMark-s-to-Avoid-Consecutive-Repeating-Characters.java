// Link: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/description/

class Solution {
    public String modifyString(String s) {
        if (s.equals("?")) {    // edge case
            return "a";
        }

        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '?') {
                // corner case 1
                if (i == 0) {
                    // look for character until its unequal
                    // with character at index i+1
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i+1]) {
                            a[i] = c;
                            break;
                        }
                    }
                }
                // corner case 1
                else if (i == a.length - 1) {
                    // look for character until its unequal
                    // with character at index i-1
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i-1]) {
                            a[i] = c;
                            break;
                        }
                    }
                }
                // regular case
                else {
                    // look for character until its unequal
                    // with characters at indices i-1 and i+1
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != a[i+1] && c != a[i-1]) {
                            a[i] = c;
                            break;
                        }
                    }
                }
            }
        }

        return new String(a);
    }
}



class Solution {
    public String modifyString(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i<a.length; i++) {
            if (a[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    a[i] = c;
                    if (i > 0 && a[i-1] == c) {
                        continue;
                    }
                    if (i < a.length - 1 && a[i+1] == c) {
                        continue;
                    }
                    break;
                }
            }
        }

        return new String(a);
    }
}


// TC: O(n * 26) => O(n)
// SC: O(n)