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
//        subset.findSubset(new ArrayList<>(Arrays.asList(1, 2, 3)));

        List<List<Integer>> result = Subset.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subset.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subset.findSubsetsDup(new int[] { 1, 1, 2, 2 });
        System.out.println("Here is the list of subsets: " + result);

        List<List<Integer>> subsets = new ArrayList<>();
        Subset.helper(0, new int[] {1, 1, 2, 2}, subsets, new ArrayList<>());
        System.out.println("Here is the list of subsets: " + subsets);
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

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size()-1;
            for (int i = 0; i <= n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    /**
     * sort the array
     * */
    public static List<List<Integer>> findSubsetsDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int start, end = 0;
        for(int i=0;i<nums.length;i++) {
            start = 0;
            if(i>start && nums[i] == nums[i-1]) {
                start = end+1;
            }
            end = subsets.size()-1;
            for(int j=start; j<=end;j++) {
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static void helper(int start, int[] nums, List<List<Integer>> subsets, List<Integer> set) {
        subsets.add(new ArrayList<>(set));
        for(int i=start;i<nums.length;i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            set.add(nums[i]);
            helper(i+1, nums, subsets, set);
            set.remove(set.size()-1);
        }
    }



}
