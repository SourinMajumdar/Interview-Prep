// A person is eligible to vote if his/her age is greater than or equal to 18.
// Define a method to find out if he/she is eligible to vote.

import java.util.Scanner;
public class Voter {
    static boolean isEligible(int age){
        return age>18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Eligible to vote?: "
                + Boolean.toString(isEligible(age)).toUpperCase());
    }
}

/*
Output:
Enter age: 16
Eligible to vote?: FALSE

Enter age: 20
Eligible to vote?: TRUE

 */
