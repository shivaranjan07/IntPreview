package algorithms.backtracking;

public class PrintOctal {
    public static void main(String[] args) {
        PrintOctal pb = new PrintOctal();
        pb.helper(2, "");
    }

    private void helper(int n, String output) {
        if(n == 0) {
            System.out.println(output);
        } else {
            for(int i=0; i < 8; i++) {
                helper(n-1, output+i);
            }
        }
    }
}
