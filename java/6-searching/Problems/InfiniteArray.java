// Find the position of an element in an infinite sorted array

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 140;
        System.out.println(ans(arr,target));
    }

    static int ans(int[] arr, int target){
        // initially start with a box of size 2
        int start = 0, end = 1;
        while(target>arr[end]){    // if the target lies beyond the element at the end
            int newStart = end+1;   // make new start from the element next to end i.e. end+1
            end = end + (end-start+1)*2;    // this would be the new end: end+[end-(start-1)]
            start = newStart;   // replacing the original start with new start
        }
        return binarySearch(arr,target,start,end);  // calling the binary search function with updated range parameters where the target possibly lies
    }

    static int binarySearch(int[] array, int target, int start, int end){
        while(start<=end){
            int mid = start +(end-start)/2;
            if(target<array[mid]) end = mid-1;
            else if (target>array[mid]) start = mid+1;
            else return mid;
        }
        return -1;
    }
}
// will give ArrayIndexOutOfBoundsException error because the array is finite, the end value exceeds the length of the array, but it won't happen if it's an infinite array.