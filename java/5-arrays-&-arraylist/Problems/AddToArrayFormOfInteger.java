/*
Problem: https://leetcode.com/problems/add-to-array-form-of-integer/
Solution: https://www.youtube.com/watch?v=K0NDHD-xaGo

 */

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        List<Integer> arr = new ArrayList<>();

        while(i>=0 || k>0){
            if(i>=0){
                arr.add((num[i]+k)%10);
                k = (num[i]+k)/10;
            }else{
                arr.add(k%10);
                k /= 10;
            }
            i--;
        }

        Collections.reverse(arr);
        return arr;
    }
}