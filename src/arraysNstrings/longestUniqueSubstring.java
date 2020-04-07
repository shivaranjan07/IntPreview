package arraysNstrings;


/**
 * aapplestooiipp -> longestUniqueSubstring is plesto and length is 5
 * Given a String of size n find the longest substring length that has all the unique characters
 * a array can contain n-k+1 sub array(if k is known)
 *
 * */
public class longestUniqueSubstring {
    public static void main(String[] args) {
        String str = "aapplestooiipp";
        lengthSubString(str);
    }

    private static void lengthSubString(String str) {
        int len = str.length();
        int start = 0, end = 0;

        int[] freq = new int[256];
        int maxLen = 0;
        for(end=0;end<len;end++) {
            char c = str.charAt(end);
            int i = c - '0';
            freq[i]++;

            while(freq[i] > 1) {
                //increase start and reduce the count of freq[str[start]]-- nothing but remove start(ing chars) from current substring
                freq[str.charAt(start) - '0']--;
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        System.out.println(maxLen);
    }
}
