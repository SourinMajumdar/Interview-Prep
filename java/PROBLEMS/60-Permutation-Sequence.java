// Link: https://leetcode.com/problems/permutation-sequence/
// Solution: https://www.youtube.com/watch?v=wT7gcXLYoao

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        k--;

        StringBuilder  s = new StringBuilder();

        while (true) {
            s.append(numbers.get(k / fact));
            numbers.remove(k / fact);

            if (numbers.size() == 0) break;

            k %= fact;
            fact /= numbers.size();
        }

        return s.toString();
    }
}

//TC: O(n) * O(n) => O(n ^ 2)
// SC: O(n)