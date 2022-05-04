public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18,-12,-5,1,4,8,24,42,67,75,89};
        int target = 67;
        System.out.println(binarySearch(arr,target));
    }

    // return index of target element
    static int binarySearch(int[] array, int target){
        int start = 0, end = array.length-1;

        while(start<=end){
            // int mid = (start+end)/2;     if end and start have huge value then it'll exceed int range
            int mid = start +(end-start)/2;

            if(target<array[mid]) end = mid-1;  // if target lies in 1st half
            else if (target>array[mid]) start = mid+1;  // if target lies in 2nd half
            else return mid;

        }
        return -1;
    }
}
