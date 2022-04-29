// prints the nth term in the fibonacci series. (First term being oth)
import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1, count = 2;
        while(count<=n){
            int temp = b;
            b+=a;
            a = temp;
            count++;
        }
        System.out.println(b);
    }
}