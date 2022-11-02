// Link: https://leetcode.com/problems/minimum-genetic-mutation/

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        List<String> bankList = Arrays.asList(bank);

        q.offer(start);
        seen.add(start);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String s = q.poll();

                if (s.equals(end)) return steps;

                char[] currStr = s.toCharArray();

                for (int j = 0; j < 8; j++) {
                    char originalChar = currStr[j];

                    for (char c : "ACGT".toCharArray()) {
                        currStr[j] = c;

                        String newStr = new String(currStr);

                        if (!seen.contains(newStr) && bankList.contains(newStr)) {
                            q.offer(newStr);
                            seen.add(newStr);
                        }
                    }

                    currStr[j] = originalChar;
                }
            }

            steps++;
        }

        return -1;
    }
}

// TC: O(n), SC: O(n)