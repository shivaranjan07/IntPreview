package recursion101;


/**
 * remove the first character from String in every call and append it to the end
 * problem str
 * sub-problem str.substring(1) by removing str[0]
 * combining the results from substrings str[1:] + s[0]
 * */
public class reverseString{

    public static void main(String []args){
        System.out.println(revString("abcd"));

    }

    private static String revString(String str) {
        if(str.length() == 0) {
            return "";
        } else {
            return revString(str.substring(1)) + str.charAt(0);
        }
    }
}
