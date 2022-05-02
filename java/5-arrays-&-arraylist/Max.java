// Maximum element in an array
public class Max {
    public static void main(String[] args) {
        int[] arr = {1,3, 5, 7, 9};
        System.out.println(max(arr));
    }
    static int max(int[] array){
        if(array.length==0) return -1;
        int max = array[0];
        for(int ele: array){
            if(ele>max) max = ele;
        }
        return max;

//        for(int i = 0; i<array.length;++i){
//            if(array[i]>max) max=array[i];
//        }
//
//        return max;
    }
}
