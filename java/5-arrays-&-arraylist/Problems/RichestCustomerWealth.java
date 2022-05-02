/*

LEETCODE:

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the (i)th customer has in the (j)th bank. Return the wealth that the richest customer has. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Example 1:
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6

Example 2:
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10

Example 3:
Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

Problem link: https://leetcode.com/problems/richest-customer-wealth/

 */

class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] wealth = new int[accounts.length];
        int max = 0;
        for (int[] rows : accounts) {
            int sum = 0;
            for (int money : rows) {
                sum += money;
            }
            if (sum > max) max = sum;
        }
        return max;
    }
}