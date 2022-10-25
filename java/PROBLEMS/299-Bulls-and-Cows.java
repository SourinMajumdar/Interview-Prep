// Link: https://leetcode.com/problems/bulls-and-cows/

// Solution: https://www.youtube.com/watch?v=sEGa8F2pMS8


class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        int[] secretFreq = new int[10],
                guessFreq = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) bulls++;
            else {
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return bulls + "A" + cows + "B";
    }
}

// TC: O(n), SC: O(1)



class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        Map<Character, Integer> secretFreq = new HashMap<>();
        Map<Character, Integer> guessFreq = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) bulls++;
            else {
                secretFreq.put(s, secretFreq.getOrDefault(s, 0) + 1);
                guessFreq.put(g, guessFreq.getOrDefault(g, 0) + 1);
            }
        }

        for (char c : secretFreq.keySet()) {
            if (guessFreq.containsKey(c)) {
                cows += Math.min(secretFreq.get(c), guessFreq.get(c));
            }
        }

        return bulls + "A" + cows + "B";
    }
}

// TC: O(n), SC: O(n)