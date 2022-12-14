// Link: https://practice.geeksforgeeks.org/problems/complement3911/1
// https://www.youtube.com/watch?v=2_PLnHfdwF4

class Solve {
    Vector<Integer> findRange(String str, int n) {
        int left = -1, ansL = -1, ansR = -1;
        int count = 0, max = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') count++;
            else {
                count--;
                if (count < 0) {
                    count = 0;
                    left = -1;
                }
            }

            if (count == 1 && left == -1) {
                left = i;
            }

            if (count > max) {
                max = count;
                ansL = left;
                ansR = i;
            }
        }

        Vector<Integer> ans = new Vector<>();

        if (ansL == -1) ans.add(-1);
        else {
            ans.add(ansL + 1);
            ans.add(ansR + 1);
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)