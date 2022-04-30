// Write a function to check if a given triplet is a Pythagorean triplet or not.

import java.util.ArrayList;
import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(isPTriplet(a,b,c));
    }

    static boolean isPTriplet(int a, int b, int c){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add((int) Math.pow(a,2));
        arr.add((int) Math.pow(b,2));
        arr.add((int) Math.pow(c,2));
        return arr.get(0) + arr.get(1) == arr.get(2) ||
                arr.get(0) == arr.get(1) + arr.get(2) ||
                arr.get(1) == arr.get(0) + arr.get(2);

    }
}

/*
Output:
1 2 3
false

4 3 5
true

15 25 20
true
 */
