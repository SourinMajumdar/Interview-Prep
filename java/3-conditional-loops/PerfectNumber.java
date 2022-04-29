// A perfect number is a one whose sum of factors (including itself) is equal to the number itself.

import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = 0, i=1;

        // Finding and adding factors
        while(i<n){
            if(n%i==0){
                sum+=i;
            }
            i++;
        }

        if(sum==n) System.out.println("Perfect number");
        else System.out.println("Nahh");
    }
}

// 28, 496, 8128 re perfect numbers
