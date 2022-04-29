/* Write a program to print the sum of negative numbers,
   sum of positive even numbers and the
   sum of positive odd numbers from a list of numbers (N) entered by the user.
   The list terminates when the user enters a 0. */

import java.util.*;
public class EvenOddSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        while(true){
            int x = sc.nextInt();
            if(x<0) neg.add(x);
            else if(x==0) break;
            else
                if (x % 2 == 0) even.add(x);
                else odd.add(x);
        }

        int sum = 0;
        for(Integer x: odd) sum+=x;
        System.out.print("Sum of odd inputs: " + sum +"\n");

        sum = 0;
        for(Integer x: even) sum+=x;
        System.out.print("Sum of even inputs: " + sum +"\n");

        sum = 0;
        for(Integer x: neg) sum+=x;
        System.out.print("Sum of negative inputs: " +sum +"\n");
    }
}
