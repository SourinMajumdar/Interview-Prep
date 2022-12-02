// Link: https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-convert-one-string-into-another-with-given-constraints4116/1

class Solution {
    int isItPossible(String S, String T, int M, int N) {
        if (M != N) return 0;

        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'A') a++;
            else if (T.charAt(i) == 'B') b++;

            if (T.charAt(i) == 'A') a--;
            else if (T.charAt(i) == 'B') b--;
        }

        if (a != 0 || b != 0) return 0;

        int i = 0, j = 0;

        while (i < N && j < M) {
            while (i < N && S.charAt(i) == '#') i++;
            while (j < M && T.charAt(j) == '#') j++;

            if (i == N || j == M) break;

            if (S.charAt(i) == 'A') {
                if (T.charAt(j) == 'A') {
                    if (j > i) return 0;
                    else i++; j++;
                }
                else return 0;
            }
            else {
                if (T.charAt(j) == 'B') {
                    if (j < i) return 0;
                    else i++; j++;
                }
                else return 0;
            }
        }

        return 1;
    }
}

// TC: O(N), SC: O(1)


// TLE
class Solution {
    int isItPossible(String S, String T, int M, int N) {
        return S.replaceAll("#","").equals(T.replaceAll("#",""))?1:0;
    }
};