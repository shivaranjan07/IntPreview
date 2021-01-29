package algorithms.dp;
import java.util.Scanner;

public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int e1=1, e0=1;

        for(int i=2;i<=n;i++) {
            int ne1 = e1+e0;
            int ne0 = e1;

            e1 = ne1;
            e0 = ne0;
        }

        System.out.println(e1+e0);
    }

}
