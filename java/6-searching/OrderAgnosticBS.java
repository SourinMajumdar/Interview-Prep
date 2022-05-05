public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr1 = {-18,-12,-5,1,4,8,24,42,67,75,89};
        int target1 = 67;
        System.out.println(search(arr1,target1));
        int[] arr2 = {90,80,65,48,26,5,-5,-12};
        int target2 = 26;
        System.out.println(search(arr2,target2));

    }

    static int search(int[] arr, int target){
        int start = 0, end = arr.length-1;
        boolean isAscending = arr[start]<arr[end];
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==target) return mid;
            if(isAscending){
                if(target<arr[mid]) end = mid-1;  // if target lies in 1st half
                else start = mid+1;
            }else{
                if(target>arr[mid]) end = mid-1;  // if target lies in 1st half
                else start = mid+1;
            }
        }
        return -1;
    }
}
