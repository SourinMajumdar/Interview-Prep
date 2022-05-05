public class Floor {
    public static void main(String[] args) {
        int[] arr = {-18,-12,-5,1,4,8,24,42,67,75,89};
        int target = 80;
        System.out.println(ceiling(arr,target));
    }
    static int ceiling(int[] array, int target){
        int start = 0, end = array.length-1;
        if(target<array[start]) return -1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(target<array[mid]) end = mid-1;  // if target lies in 1st half
            else if (target>array[mid]) start = mid+1;  // if target lies in 2nd half
            else return mid;
        }
        return array[end]; // returns the floor element
    }
}
