// Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

class Solution {
    private class UnionFind {
        private int[] parentArr;
        private UnionFind(int n) {
            parentArr = new int[n];
            for (int i = 0; i < n; i++) {
                parentArr[i] = i;
            }
        }

        private int getParent(int i) {
            return (parentArr[i] == i)? i : (parentArr[i] = getParent(parentArr[i]));
        }

        private void union(int i, int j) {
            int parent1 = getParent(i);
            int parent2 = getParent(j);
            if (parent1 < parent2) {
                parentArr[parent2] = parent1;
            } else {
                parentArr[parent1] = parent2;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            uf.union(c1, c2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int smallestMappedChar = uf.getParent(baseStr.charAt(i) - 'a');
            sb.append((char) (smallestMappedChar + 'a'));
        }

        return sb.toString();
    }
}

// TC: O(


class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Smallest Lexicographically Equivalent Letter = SLEL
        // creating an array of size 26 which will store the SLELs
        char[] arr = new char[26];
        // By default, each letter itself is it's SLEL
        for (char c = 'a'; c <= 'z'; c++) {
            arr[c - 'a'] = c;
        }

        // Now we will iterate over the strings and map them to their SLELs
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            // say we have characters 'p' and 'm' at same index of s1 and s2,
            // out of both of them 'm' is smaller, so it is SLEL for 'p'
            char toReplace = (char) Math.max(arr[c1-'a'], arr[c2-'a']);     // replace: max('p', 'm') = 'p'
            char replaceWith = (char) Math.min(arr[c1-'a'], arr[c2-'a']);   // with: min('p', 'm') = 'm'
            // we will wherever 'p' is and put 'm' in its place.
            for (int j = 0; j < 26; j++) {
                if (arr[j] == toReplace) {  // found 'p'
                    arr[j] = replaceWith;   // put 'm'
                }
            }

            // say for example we have 'k' and 'r', so we will put 'k' in places of 'r's.
            // then we get the pair 'r' and 's', but in place of 'r' we have already put 'k' (arr['r'] = 'k')
            // REPLACE : max(arr['r'], arr['s']) => max('k', 's') => 's'
            // WITH    : min(arr['r'], arr['s']) => min('k', 's') => 'k'
            // So wherever 's' is in the array, we will put 'k' in its place
            // which means for 's', 'k' is the SLEL
        }

        StringBuilder sb = new StringBuilder();     // create a stringbuilder to build our answer string
        // for each character in baseStr, we will append the character which is put in its index as its SLEL
        for (char c : baseStr.toCharArray()) {
            sb.append(arr[c - 'a']);
        }

        return sb.toString();   // return the answer string
    }
}

// TC: O(n * 26) + O(k) => O(n + k)
// n be the length of s1 and s2
// k be the length of baseStr

// SC: O(26) => O(1)



class Solution {
    private Map<Character, List<Character>> adj = new HashMap<>();  // globally initialise the adjacency map
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // populate the adjacency map
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            adj.putIfAbsent(c1, new ArrayList<>());
            adj.putIfAbsent(c2, new ArrayList<>());
            adj.get(c1).add(c2);
            adj.get(c2).add(c1);
        }

        // Smallest Lexicographically Equivalent Letter = SLEL
        StringBuilder sb = new StringBuilder();     // to store the answer string
        for (char c : baseStr.toCharArray()) {
            // we will perform a dfs and find the SLEL corresponding to each character in baseStr
            // we also paa in a boolean visited array to avoid going back to same characters where we came from
            char smallestChar = DFS(c, new boolean[26]);
            sb.append(smallestChar);    // append the SLEL to the stringbuilder
        }

        return sb.toString();       // return the answer string
    }

    private char DFS(char currChar, boolean[] visited) {
        // since we have visited this letter (currChar), we mark it so we don't visit it again
        visited[currChar - 'a'] = true;
        // if the character is not in our adjacency list, means it wasn't present in s1 or s2
        // So it itself is it's SLEL
        if (!adj.containsKey(currChar)) {
            return currChar;    // so we return currChar itself
        }

        // now lets initialise our SLEL character variable with currChar
        // we assume our character itself is it's SLEL
        char smallestChar = currChar;
        for (char childChar : adj.get(currChar)) {     // we look at all characters connected to current character
            if (!visited[childChar - 'a']) {           // if it wasn't visited already, we do some work
                // since our currChar is connected to childChar, we will see what the SLEL for our childChar is
                char smallestConnectedChar = DFS(childChar, visited);  // it will fetch us the SLEL for our childChar
                // the SLEL for our currChar would be the smaller character between itself and the SLEL of child
                smallestChar = (char) Math.min(smallestChar, smallestConnectedChar);
            }
        }

        return smallestChar;    // we will return the SLEL (also it will be utilised during backtracking)
    }
}

// TC: O(m * (v + e)), SC: O(v + e)