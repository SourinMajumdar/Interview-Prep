/*
Write a program that will ask the user to enter his/her marks (out of 100).
Define a method that will display grades according to the marks entered as below:

Marks        Grade
91-100         AA
81-90          AB
71-80          BB
61-70          BC
51-60          CD
41-50          DD
<=40          Fail

 */


import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();
        System.out.println(grade(marks));
    }
    static String grade(int n){
        String str;
        if(n>91) str ="AA";
        else if (n>81) str = "AB";
        else if (n>71) str = "BB";
        else if (n>61) str = "BC";
        else if (n>51) str = "CD";
        else if (n>41) str = "DD";
        else str = "Fail";
        return str;
    }
}
