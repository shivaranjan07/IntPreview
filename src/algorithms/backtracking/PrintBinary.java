package algorithms.backtracking;


/**
 * Print binary digits of size n, BT
 * add zero once then add one once
 * 000 backtrack the last zero
 * 001 backtrack the last one
 * 00 backtrack the last zero
 * 01
 * 010 saga continues...
 *
 * */
public class PrintBinary {
    public static void main(String[] args) {
        PrintBinary pb = new PrintBinary();
        pb.helper(3, "");
    }

    private void helper(int n, String output) {
        if(n == 0) {
            System.out.println(output);
        } else {
            for(int i=0; i < 2; i++) {
                helper(n-1, output+i);
            }
        }
    }
}
