public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 7, 67, 23, 56, 12, 122, 98, 75};
        int target = 12;
        System.out.println(linearSearch(arr,target));
    }

    static int linearSearch(int[] arr, int target) {
        if(arr.length==0) return -1;    // if size = 0
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if(element==target) return i;
        }
        return -1;  // if element not found
    }
}