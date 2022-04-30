// Write a program to print the circumference and area of a circle of radius entered by user by defining your own method.

import java.util.Scanner;

public class Circle {

    static float circumference(float r){return (float)(2*3.14*r);}
    static float area(float r){return (float)(3.14*r*r);}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius  = ");
        float radius = sc.nextFloat();
        System.out.println("Circumference = " + circumference(radius) + " units");
        System.out.println("Area          = " + area(radius) + " sq.units");
    }
}

/*
Output:

Enter radius  = 30
Circumference = 188.4 units
Area          = 2826.0 sq.units

 */
