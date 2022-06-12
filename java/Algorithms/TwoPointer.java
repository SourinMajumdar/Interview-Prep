/*
Two Pointers Technique:

Two pointers is really an easy and effective technique that is typically used for searching pairs in a sorted array.
Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
*/

public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {10, 20, 35, 50, 75, 80};
        System.out.println(twoPtr(arr,6,70));
    }

    static  int twoPtr(int[] arr, int size, int sum){
        int firstPtr = 0, secondPtr = size-1;

        while(firstPtr<secondPtr){
            if(arr[firstPtr] + arr[secondPtr] == sum) return 1;  // pair found

            else if(arr[firstPtr] + arr[secondPtr] > sum) secondPtr--;
            else firstPtr++;        // arr[firstPtr] + arr[secondPtr] < sum
        }
        return -1; // not found
    }
}