import java.util.Scanner;
class koshto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Preparation er ki obostha: ");
        int prep_status = sc.nextInt();
        boolean pass = prep_status >= 30;

        if(pass){
            System.out.println("No one gives a damn!");
        }else{
            System.out.println("""
                    Tata bye bye goodbye khatam gaya!
                    lmao ded xd
                    chakri left the chat""");
        }
        System.out.println(BackLagarChance(prep_status));
    }
    static String BackLagarChance(int prep_Status){
        if(prep_Status<30){
            return "Back lagar chance ase, bhalo koira poro bokachoda!";
        }else{
            return "safe side ey thakle moja marte hoibo kotha nai, giya poro"
        }
    }
}
