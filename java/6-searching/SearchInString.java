public class SearchInString {
    public static void main(String[] args) {
        String str = "Sourin";
        char target = 'u';
        System.out.println(search(str, target));
        System.out.println(search2(str, target));
    }

    static boolean search(String str, char target){
        if(str.length()==0) return false;

        // using for
        for (int i = 0; i < str.length(); i++) {
            if(target==str.charAt(i)) return true;
        }
        return false;
    }

    static boolean search2(String str, char target){
        if(str.length()==0) return false;

        // using for each
        for (char ch: str.toCharArray()) {
            if(target==ch) return true;
        }
        return false;
    }
}
