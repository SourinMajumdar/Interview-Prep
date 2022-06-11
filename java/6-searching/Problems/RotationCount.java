// Find the number of rotations in a rotated sorted array

package Problems;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(rotationCount(arr));
    }

    static int rotationCount(int[] arr) {
        return findPivot(arr)+1;
    }

    static int findPivot(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]) return mid;
            if(mid>start && arr[mid]<arr[mid-1]) return mid-1;
            if(arr[start]>arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
