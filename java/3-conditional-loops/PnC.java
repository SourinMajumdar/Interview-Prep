import java.util.Scanner;
public class PnC {
    static int factorial(int x){
        int fact = 1, i=1;
        while(i<=x){
            fact *= i;
            i++;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        int nPr = factorial(n)/factorial(n-r);
        System.out.println("nPr: " + nPr);

        int nCr = factorial(n)/(factorial(n-r)*factorial(r));
        System.out.println("nCr: " + nCr);
    }
}

/*

Output:
7
3
nPr: 210
nCr: 35

 */
