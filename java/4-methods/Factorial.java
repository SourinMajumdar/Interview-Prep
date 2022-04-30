// Write a program to print the factorial of a number by defining a method named 'Factorial'.

import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    static int factorial(int n){
        int fact = 1, i=1;
        while(i<=n){
            fact *= i;
            i++;
        }
        return fact;
    }
}
