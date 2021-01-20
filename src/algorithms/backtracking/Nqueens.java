package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Nqueens
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String []argv)
    {
        Scanner fr = new Scanner(System.in);
        int t = fr.nextInt();
        while(t-- > 0) {
            int n = fr.nextInt();
            System.out.println(n);
            int[][] board = new int[n][n];
            nqueenUtilty(board, -1, n);
            System.out.println();
        }
    }

    private static boolean nqueenUtilty(int[][] board, int row, int n) {
        if(n==2 || n==3)
        {
            System.out.println("-1");
            return false;
        }
        if(row == n-1) {
            System.out.print("[");
            for(int i =0; i<n;i++) {
                for(int j =0;j<n;j++) {
                    if (board[i][j] == 1)
                        System.out.print((j + 1) + " ");
                }
            }
            System.out.print("] ");
            return false;
        } else {

            //choices - cols 0 to n
            for(int col=0;col<n;col++) {
               int newrow = row + 1;
                if(isValid(board, newrow, col, n)) {
                    board[newrow][col] = 1;
                    if(nqueenUtilty(board, newrow, n)){
                        return true;
                    }
                    board[newrow][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int n) {
//        boolean valid = true;
        //check in the same column
        for(int i =0;i<n;i++) {
            if(board[i][col] == 1) {
//                valid = false;
                return false;
            }
        }

        //check upper left diagonal part
        for(int i = row, j = col; i>=0  && j >=0; i--,j--) {
            if(board[i][j] == 1) {
//                valid = false;
                return false;
            }
        }

        //check upper right diagonal part
        for(int i=row, j=col; i>=0 && j <n;i--,j++) {
            if(board[i][j] == 1) {
//                valid = false;
                return false;
            }
        }

        return true;
    }
}
