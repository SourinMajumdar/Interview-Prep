import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        //input using for loop
        for(int i = 0; i<5; ++i){
            arr.add(sc.nextInt());
        }

        //printing
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) +" ");
        }
        System.out.println();

        // printing using for each
        for (Integer ele: arr) {
            System.out.print(ele +" ");
        }
        System.out.println();

        //printing using Iterator
        Iterator<Integer> i = arr.iterator();
        while (i.hasNext()){
            System.out.print(i.next() +" ");
        }
        System.out.println();

        //using toString() method
        System.out.println(Arrays.toString(arr.toArray()));
    }
}
