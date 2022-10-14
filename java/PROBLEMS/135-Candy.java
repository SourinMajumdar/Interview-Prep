// Link: https://leetcode.com/problems/candy/

// Solution: https://www.youtube.com/watch?v=sSwB4ggwzVY


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] l2r = new int[n], r2l = new int[n];

        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                l2r[i + 1] = l2r[i] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                r2l[i - 1] = r2l[i] + 1;
            }
        }

        int[] finalArr = new int[n];

        for (int i = 0; i < n; i++) {
            finalArr[i] = Math.max(l2r[i], r2l[i]);
        }

        int totalCandies = 0;
        for (int i : finalArr) totalCandies += i;

        return totalCandies;
    }
}

// TC: 6 * O(n) => O(n)
// SC: 3 * O(n) => O(n)


// Extra space reduced

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] distribution = new int[n];

        Arrays.fill(distribution, 1);

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                distribution[i + 1] = distribution[i] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (distribution[i - 1] <= distribution[i]) {
                    distribution[i - 1] = distribution[i] + 1;
                }
            }
        }

        int totalCandies = 0;
        for (int i : distribution) totalCandies += i;

        return totalCandies;
    }
}

// TC: 4 * O(n) => O(n)
// SC: O(n)