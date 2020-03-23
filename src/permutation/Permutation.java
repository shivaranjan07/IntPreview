package permutation;

import java.util.Arrays;

/**
 * Permutation - can be used with different data type arrays
 * logic - (backtracking)
 *  a) maintain count array corresponding to input array i.e each indices of input array will have count 1,
 *  when we visit that character we will reduce the count and based on the recursion level, we will add that character(index value)
 *  to result array. increment the level as we go to next recursion level
 *  b) each time look for character/index whose count is non zero
 *
 *  https://www.educative.io/page/11000001/90001
 * */
public class Permutation {
    public static void main(String ...balls) {
        Permutation permutation = new Permutation();
        String[] input = {"a", "b", "c"};
        permutation.permute(input);
    }

    private void permute(String[] input) {
        int[] count = new int[input.length];
        Arrays.fill(count, 1);
        String[] result = new String[input.length];
        permuteHelper(input, result, count, 0);
    }

    private void permuteHelper(String[] input, String[] result, int[] count, int level) {
        if(level == input.length) {
            printResult(result);
        } else {
            for(int i=0; i<input.length; i++) {
                if(count[i] == 0) {
                    continue;
                }
                result[level] = input[i];
                count[i]--;
                permuteHelper(input, result, count, level+1);
                count[i]++;
            }
        }
    }

    private void printResult(String[] result) {
        for(String str: result) {
            System.out.print(str);
        }
        System.out.println();
    }
}
