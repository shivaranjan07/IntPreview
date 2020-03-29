package arraysNstrings;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * Hackerrank problem -> https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * Lily has a chocolate bar that she wants to share it with Ron for his birthday.
 * Each of the squares has an integer on it. She decides to share a contiguous segment of the bar selected such that
 * the length of the segment matches Ron's birth month and the sum of the integers on the squares is equal to his birth day
 * You must determine how many ways she can divide the chocolate.
 * */
public class BirthdayChoco {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int start = 0, end = 0;
        int n = s.size();
        //if(n < m) return 0;
        int sum = 0, count=0;
        for(end=0; end < n; end++) {
            sum += s.get(end);
            if(end >= m-1) {
                if(sum == d) {
                    count++;
                }
                sum -= s.get(start);
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String[] sItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        List<Integer> s = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int sItem = Integer.parseInt(sItems[i]);
//            s.add(sItem);
//        }
//
//        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int d = Integer.parseInt(dm[0]);
//
//        int m = Integer.parseInt(dm[1]);
//
//        int result = birthday(s, d, m);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();

        Integer[] arr = {1, 2, 1, 3, 2};
        System.out.println("total ways "+birthday(Arrays.asList(arr), 3, 2) + " ");
    }
}

