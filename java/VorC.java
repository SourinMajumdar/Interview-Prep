// To check if a given character (letter) is vowel or consonant

import java.util.Scanner;
public class VorC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char ch = in.next().charAt(0);
        switch (ch){
            case 'a','e','i','o','u','A','E','I','O','U' -> System.out.println("Vowel");
            default -> System.out.println("Consonant");
        }
    }
}

