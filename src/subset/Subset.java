package subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * BackTracking
 * subsetHelper1 - recurse on input and result, without and with a element
 * subsetHelper2 - it's a combination, so use i+1 to point to the beginning of the possible path
 * */
public class Subset {
    public static void main(String[] args) {
        Subset subset = new Subset();
        subset.findSubset(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    private void findSubset(ArrayList<Integer> vect) {
//        subsetHelper(vect, new ArrayList<Integer>(), 1);
        List<List<Integer>> result = new ArrayList<>();
        subsetHelper2(result, vect, new ArrayList<Integer>(), 0,1);
        for(List<Integer> arr: result) {
            System.out.println(arr);
        }
    }

    // find the next place(denoted by start) which is free to place the next level number
    private void subsetHelper2(List<List<Integer>> result, ArrayList<Integer> vect, ArrayList<Integer> chosen, int start, int level) {
        String tab = "\t";

        for(int j=1;j<level-1;j++) {
            tab+="\t";
        }

        System.out.println(tab+"helper("+result+", "+"***"+", "+chosen+") level "+level);
        result.add(new ArrayList<Integer>(chosen));
        for(int i=start; i<vect.size(); i++) {
            chosen.add(vect.get(i));
            subsetHelper2(result, vect, chosen, i+1, level+1);
            chosen.remove(chosen.size()-1);
        }
    }

    private void subsetHelper(ArrayList<Integer> vect, ArrayList<Integer> chosen, int level) {

        //basecase
        if(vect.isEmpty()) {
            System.out.println(chosen);
        } else {
            //choose
            Integer in = vect.get(0);
            vect.remove(0);

            //explore without elem
            chosen.add(in);
            subsetHelper(vect, chosen, level+1);

            //explore with elem
            chosen.remove(chosen.size()-1);
            subsetHelper(vect, chosen, level+1);

            //unchoose
            vect.add(0, in);
        }
    }
}
