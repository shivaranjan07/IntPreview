package recursion101;

import java.util.ArrayList;

public class StringSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> arr = gss(str);
        System.out.println(arr);
    }

    //generate sub sequence
    // lf -> (bc) __, _c, b_, bc
    // add "" & a to bc
    private static ArrayList<String> gss(String str) {
        if(str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> ros = gss(str.substring(1));

        ArrayList<String> mres = new ArrayList<>();
        for(String rstr: ros) {
            mres.add(""+rstr);
        }
        for(String rstr:ros) {
            mres.add(ch+rstr);
        }

        return mres;
    }
}
