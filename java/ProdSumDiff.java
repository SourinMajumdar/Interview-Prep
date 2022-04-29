import java.util.Scanner;

// Given an integer number n, return the difference between the product of its digits and the sum of its digits.
public class ProdSumDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(subtractProductAndSum(n));
    }
    static int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while(n>0){
            sum+=n%10;
            product*=n%10;
            n/=10;
        }
        return product-sum;
    }
}
/*
Output:
234
15

4421
21
 */