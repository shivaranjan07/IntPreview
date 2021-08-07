package recursion101;

public class PalindromePartitioning {
    public static void main(String[] args) {
        solve("abaaba", "", 0);
    }

    private static void solve(String str, String asf, int level) {
        String tab ="\t";
        for(int i=0;i<=level;i++) {
            tab += "\t";
        }
        System.out.println(tab+"solve( "+str+" "+asf+")");

        if(str.length() == 0)
            System.out.println(asf);

        for(int i=0;i<str.length();i++) {
            String prefix = str.substring(0, i+1);
            String ros = str.substring(i+1);

            if(isPalindrome(prefix)) {
                solve(ros, asf+"("+prefix+")", level+1);
            }
        }
    }

    private static boolean isPalindrome(String prefix) {
        int i=0, j=prefix.length()-1;
        if(j==0) return true;
        while(i<j) {
            if(prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
