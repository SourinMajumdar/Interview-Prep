// Write a function that returns all prime numbers between two given numbers.

import java.util.ArrayList;

public class PrimePrinter {
    public static void main(String[] args) {
        int a = 1, b = 200;
        System.out.println(printPrime(a,b));
    }

    static String printPrime(int a, int b){
        ArrayList<Integer> arr = new ArrayList<>();
        int n =a+1;
        while(n<b){
            if(isPrime(n)) arr.add(n);
            n++;
        }
        return arr.toString();

    }
    static boolean isPrime(int n){
        int i = 2;
        while(i<n){
            if(n%i==0) return false;
            ++i;
        }
        return true;
    }
}
