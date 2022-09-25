// Link: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;

        while(n > 0){
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return product - sum;
    }
}

// TC: O(n) - whe n is the number of digits
// SC: O(1)