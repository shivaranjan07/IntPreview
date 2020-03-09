package algorithms.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * LeetCode problem
* https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Solution use BackTracking
 * fix the Character(from first digit) and append the characters from second digit
* */
class LetterCombination {
    Map<String, String> dialPad = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    private void letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        //to make this code to work in leetCode add below line
        //if(digits.isEmpty()) return result;
        helper(digits,  result, "", 1);
        System.out.println(result);
        //instead of sout return result;
    }

    private void helper(String digits, List<String> result, String output, int level) {
        if(digits.length() == 0) {
            result.add(output);
        } else {
            String digit = digits.substring(0,1);
            String possibility = dialPad.get(digit);
            for(int i=0;i<possibility.length();i++) {
                helper(digits.substring(1),  result, output+possibility.substring(i, i+1), level+1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombination  soln = new LetterCombination();
        soln.letterCombinations("23");
    }
}

