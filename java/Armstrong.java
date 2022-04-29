import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum=0;
        int temp = n;
        String strn = Integer.toString(n);
        while(temp>0){
            sum += Math.pow(temp%10, strn.length());
            temp /= 10;
        }

        if (sum==n) System.out.println("Armstrong number");
        else System.out.println("Not Armstrong number");
    }
}

/*
Output:
153
Armstrong number

1634
Armstrong number

124
Not Armstrong number
*/
