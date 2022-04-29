import java.util.Scanner;

// Input a number and print all the factors of that number (use loops).
public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = 1;
        while(i<=n){
            if(n%i==0){
                System.out.println(i +" ");

            }
            i++;
        }
    }
}

/*
Output;
100
1
2
4
5
10
20
25
50
100
 */