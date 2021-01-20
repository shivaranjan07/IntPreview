package recursion101;

import java.io.*;
import java.util.*;

public class RecursionArrays {

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while(st == null ||!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(this.next());
        }

        long nextLong() {
            return Long.parseLong(this.next());
        }

        double nextDouble() {
            return Double.parseDouble(this.next());
        }

        String nextLine() {
            String str = "";
            try {
                str=br.readLine();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++) {
            arr[i]=fr.nextInt();
        }
        int x = fr.nextInt();
        System.out.println(lastIndex(arr,0,x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length) {
            return -1;
        }

        int ires = lastIndex(arr, idx+1, x);

        if(ires == -1) {
            if(arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        }

        return ires;
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if(idx == arr.length) {
            int[] bres = new int[fsf];
            return bres;
        }

        if(arr[idx] == x) {
            int[] mres = allIndices(arr, x, idx+1, fsf+1);
            mres[fsf] = idx;
            return mres;
        } else {
            int[] res = allIndices(arr, x, idx+1, fsf);
            return res;
        }


    }

}
