package recursion101;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    /**
     * lf fact(n-1) already works
     * rec n * fact(n-1)
     * bc = n == 0 -> 1
     * */
    private static int fact(int n) {
        if(n==0) {
            return 1;
        } else {
            return n*fact(n-1);
        }
    }
}
