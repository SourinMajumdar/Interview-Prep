import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pal = sc.next();
        System.out.println(isPalindrome(pal));
    }

    static boolean isPalindrome(String str) {
        String str1 = str.toLowerCase();
        int i = 0, j = str.length()-1;
        while(i<j){
            if(str1.charAt(i) != str1.charAt(j)) return false;
            ++i;--j;
        }
        return true;
    }
}
