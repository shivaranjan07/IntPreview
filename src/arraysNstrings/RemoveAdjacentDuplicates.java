package arraysNstrings;

public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s, int k) {
        int i=0, n=s.length();
        char[] res = s.toCharArray();

        for(int j=0;j<n;j++, i++) {
            res[i]=res[j];
            if(i >= k-1 && res[i-(k-1)] == res[i] ) {
                System.out.println(new String(res));
                i-=k;
            }
        }

        return new String(res, 0, i);
    }

    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(str, 3));
    }
}


