package algorithms.backtracking;

import java.util.Scanner;


/**
 * 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet
 from a to z.
 2. You have to find the maximum score of any valid set of words formed by using the given
 alphabets.
 3. A word can not be used more than one time.
 4. Each alphabet can be used only once.
 5. It is not necessary to use all the given alphabets.


 Input Format
 A number N representing number of words
 N space separated strings
 A number M representing number of alphabets(might be repeating)
 M space separated characters
 26 numbers representing score of unique alphabets from a to z.

 Sample Input
 4
 dog cat dad good
 9
 a b c d d d g o o
 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0


 Sample Output
 23
 *
 * */
public class MaxScore {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx == words.length) {
            return 0;
        }

        //not included
        int sno = solution(words, farr, score, idx+1); //0+solution(words, farr, score, idx+1);

        int sword = 0;
        boolean flag = true;
        String word = words[idx];
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(farr[ch - 'a'] == 0) {
                flag = false;
            }
            farr[ch - 'a']--;

            sword+=score[ch - 'a'];
        }

        int sadd = 0;
        if(flag) {
            sadd = sword+solution(words, farr, score, idx+1);
        }

        // backtrack
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }


        return Math.max(sno, sadd);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }

        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
