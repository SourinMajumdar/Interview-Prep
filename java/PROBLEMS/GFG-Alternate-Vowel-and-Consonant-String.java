// Link: https://practice.geeksforgeeks.org/problems/alternate-vowel-and-consonant-string2939/1

class Solution{
    public String rearrange(String S, int N){
        int[] vowelFreq = new int[26], consFreq = new int[26];
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        int vowelCount = 0, consCount = 0;
        char smallestVowel = 'u', smallestCons = 'z';

        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                vowelFreq[c - 'a']++;
                vowelCount++;
                smallestVowel = (char) Math.min((int) smallestVowel, (int) c);
            }
            else {
                consFreq[c - 'a']++;
                consCount++;
                smallestCons = (char) Math.min((int) smallestCons, (int) c);
            }
        }

        if (Math.abs(vowelCount - consCount) > 1) return "-1";

        boolean putVowel  = false;  // vowelCount < consCount

        if (vowelCount > consCount) putVowel = true;
        else if (vowelCount == consCount) {
            putVowel = smallestVowel < smallestCons;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < 26 && j < 26) {
            if (putVowel) {
                while (i < 26 && vowelFreq[i] == 0) i++;
                if (i == 26) break;

                sb.append((char) ('a' + i));
                vowelFreq[i]--;
                putVowel = false;
            }
            else {
                while (j < 26 && consFreq[j] == 0) j++;
                if (j == 26) break;

                sb.append((char) ('a' + j));
                consFreq[j]--;
                putVowel = true;
            }
        }

        return sb.toString();
    }
}

// TC: O(n), SC: O(1)