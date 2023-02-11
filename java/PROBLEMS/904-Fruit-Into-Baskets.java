// Link: https://leetcode.com/problems/fruit-into-baskets/

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> basket = new HashSet<>();
            int j = i;
            for (; j < n; j++) {
                if (basket.size() == 2 && !basket.contains(fruits[j])) {
                    break;
                }
                basket.add(fruits[j]);
            }
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}

// TC: O(n^2), SC: O(1)




class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0;
        int ans = 0;
        Map<Integer, Integer> b = new HashMap<>();
        while (j < fruits.length) {
            b.put(fruits[j], 1 + b.getOrDefault(fruits[j], 0));
            while (b.size() > 2) {
                b.put(fruits[i], b.get(fruits[i]) - 1);
                if (b.get(fruits[i]) == 0) {
                    b.remove(fruits[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}

// TC: O(n), SC: O(1)