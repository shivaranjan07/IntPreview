package arraysNstrings.slidingWindow;

import java.util.*;


/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * */
class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int end, start = 0;
        int max = Integer.MIN_VALUE;
        for(end=0;end < str.length(); end++) {
            char right = str.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);

            while(map.size() > k) {

                char left = str.charAt(start);
                map.put(left, map.get(left)-1);
                if(map.get(left) == 0) {
                    map.remove(left);
                }
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }


    public static void main(String[] args) {
        int ans = findLength("araaci", 2);
        System.out.println(findLength("aabbcc", 3));
        System.out.println(ans);
    }
}