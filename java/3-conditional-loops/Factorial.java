import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), fact = 1, i=1;
        while(i<=n){
            fact *= i;
            i++;
        }
        System.out.println(fact);
    }
}
