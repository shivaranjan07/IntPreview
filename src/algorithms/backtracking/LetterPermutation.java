package algorithms.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem
 * 784. Letter Case Permutation
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 * we need to convert each character of string to lowercase once then to uppercase character once, if its a digit just add it to output
 * */
public class LetterPermutation {
    public static void main(String[] args) {
        LetterPermutation lt = new LetterPermutation();
        lt.permute("");
    }

    private void permute(String input) {
        //you can make result list as global variable
        List<String> result = new ArrayList<>();
        helper(input, 0, "", result);
        System.out.println(result);
    }

    private void helper(String input, int index, String output, List<String> result) {
        if(input.length() == index) {
            result.add(output);
        } else {
            if(Character.isLetter(input.charAt(index))) {
                //make a choice & explore
                helper(input, index+1, output+Character.toLowerCase(input.charAt(index)), result);
                //undo a choice & explore
                helper(input, index+1, output+Character.toUpperCase(input.charAt(index)), result);
            } else {
                helper(input, index+1, output + input.charAt(index), result);
            }
        }
    }
}
