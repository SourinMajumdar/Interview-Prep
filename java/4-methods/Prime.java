// Define a method to find out if a number is prime or not.

import java.util.Scanner;

public class Prime {
    static boolean isPrime(int n){
        int i = 2;
        while(i<n){
            if(n%i==0) return false;
            ++i;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isPrime(num));
    }
}

/*
Output:
10
false

13
true
 */