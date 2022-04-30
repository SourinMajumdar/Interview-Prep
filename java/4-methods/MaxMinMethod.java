// Define two methods to print the maximum and the minimum number respectively among three numbers entered by the user.

import java.util.Scanner;
public class MaxMinMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Max: " +max(a,b,c));
        System.out.println("Min: " +min(a,b,c));
    }
    static int max(int num1, int num2, int num3){
        if(num1>num2) return Math.max(num1, num3);
        else return Math.max(num2, num3);
    }
    static int min(int num1, int num2, int num3){
        if(num1<num2) return Math.min(num1, num3);
        else return Math.max(num2, num3);
    }
}
