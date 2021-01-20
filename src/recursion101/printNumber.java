package recursion101;


/**
 * Recursion - 101
 * print elems 1 to n
 * base case largest invalid input or smallest valid input
 *
 * */
public class printNumber {
    public static void main(String[] args) {
//        helper(10); // increasing order
//        helper2(10); // decreasing order
        printDecreasingIncreasing(5);
    }

    /**
     * lf - printDecreasingIncreasing works for n-1
     * recursive case print n printDecreasingIncreasing(n-1) print n
     * baseCase smallest/largestInvalid case n==0
     * */
    private static void printDecreasingIncreasing(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);
    }

    public static void helper(int n) {
        if(n==0) { // largest invalid input
            return;
        }
        helper(n-1);
        System.out.println(n + " ");
    }

    public static void helper2(int n) {
        if(n==1) {
            System.out.println(n + "");
            return;
        }
        System.out.println(n + " ");
        helper2(n-1);
    }
}
