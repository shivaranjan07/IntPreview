package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * permutaion - BackTracking
 * logic -> select elem from input list add it result list and subsequently remove it from input list
 * call the recursion on modified input and result
 * insert back the removed element from input list and remove the last added element from result list
 *
 *
 * output with backTracking
 * []
 * [a]
 * [a, b]
 * [a, b, c]
 * [a, c]
 * [a, c, b]
 * [b]
 * [b, a]
 * [b, a, c]
 * [b, c]
 * [b, c, a]
 * [c]
 * [c, a]
 * [c, a, b]
 * [c, b]
 * [c, b, a]
 *
 * */
public class PermuteBT {
    static public void main(String ...ntd) {
        PermuteBT permute = new PermuteBT();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        permute.permutation(list);
    }

    private void permutation(List<Integer> list) {
        permuteHelper(list, new ArrayList<Integer>());
    }

    private void permuteHelper(List<Integer> list, ArrayList<Integer> chosen) {
        //baseCase
        if(list.isEmpty()) {
            System.out.println(chosen);
        } else {
         //for each choice
         for(int i=0; i<list.size(); i++) {
             //choose
             Integer input = list.get(i);
             chosen.add(input); //{a}
             list.remove(i); //{b, c}

             //explore - recursive case
             permuteHelper(list, chosen);

             //unchoose
             chosen.remove(chosen.size() - 1);
             list.add(i , input);
         }
        }
    }
}
