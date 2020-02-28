package permutation;


import java.util.Arrays;

/**
 * permuteHelper - if the input is simple string then we can use this method
 * "a", "bc"
 * "b", "ac"
 * "c", "ca"
 *
 * permuteHelper2(BT)- fix the char at first place, then change the place of other two chars
 * a, b, c
 * swap a, a
 * swap b, b
 * swap c, c
 * abc
 * swap b, c
 * acb
 *
 * */
public class Permute3 {
    public static void main(String[] args) {
        Permute3 permute = new Permute3();
        String str = "abc";
        permute.doPerm(str);
    }

    private void doPerm(String str) {
        String prefix = "";
        permutationHelper(prefix, str);
        permutationHelper2(str.toCharArray(), 0, str.length()-1, 1);
    }

    private void permutationHelper2(char[] arr, int left, int right, int level) {

        if(left == right) { //with only one character
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=left;i <= right;i++) {
            swap(arr, left, i);
            permutationHelper2(arr, left+1, right, level+1);
            swap(arr, left, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void permutationHelper(String prefix, String suffix) {
        if(suffix.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i = 0; i < suffix.length(); i++) {
                permutationHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1));
            }
        }
    }
}
