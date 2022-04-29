// Take integer inputs till the user enters 0 and print the largest number from all.

import java.util.*;
public class LargestAfter0 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n==0) break;
            else arr.add(n);
        }
        System.out.println(Collections.max(arr));
    }
}

/*
Output:
3
76
789
45
233
0
789
 */
