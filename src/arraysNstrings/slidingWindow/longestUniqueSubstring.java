package arraysNstrings.slidingWindow;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * aapplestooiipp -> longestUniqueSubstring is plesto and length is 5
 * Given a String of size n find the longest substring length that has all the unique characters
 * a array can contain n-k+1 sub array(if k is known)
 *
 * */
public class longestUniqueSubstring {

    public static void main(String[] args) {
        String str = "abcabcbb";
        lengthSubString(str);
    }

    // O(d) ~ O(1) space complexity
    //since we can expect a fixed set of characters in the input string (e.g., 26 for English letters), we can say
    // that the algorithm runs in fixed space O(1)O(1); in this case, we can use a fixed-size array
    // instead of the HashMap.
    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        int res = 0; // result

        // last index of all characters is initialized
        // as -1
        int NO_OF_CHARS = 256;
        int [] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0;

        // Move end of current window
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }


    /**
     * We can use a HashMap to remember the last index of each character we have processed. Whenever we get a
     * repeating character, we will shrink our sliding window to ensure that we always have distinct characters
     * in the sliding window.
     * */
    public static int findLengthBest(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int end, start = 0, maxLen = Integer.MIN_VALUE;
        // try to extend the range [windowStart, windowEnd]
        for(end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if(map.containsKey(right)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                // example acbbca
                start = Math.max(start, map.get(right)+1);
            }

            map.put(right, end); // insert the 'rightChar' into the map
            maxLen = Math.max(maxLen, end-start+1); // remember the maximum length so far
        }

        return maxLen;
    }

    public static int findLength(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int end, start = 0, maxLen = Integer.MIN_VALUE;
        for(end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            map.put(right, map.getOrDefault(right, 0)+1);

            while(map.get(right) > 1) {
                char left = str.charAt(start);
                map.put(left, map.get(left)-1);
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
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
