package trees;

import java.util.*;

class Maximum {
    int maxno;
    Maximum() {
        maxno = Integer.MIN_VALUE;
    }
}

class AllPathsForSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
//        helper(root, sum, currentPath, allPaths, 0);


        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        giveAllPaths(root, currPath, all);
        System.out.println(all);

        Maximum maximum = new Maximum();
        findMaxSum(root, 0, maximum);
        System.out.println(maximum.maxno);

        return allPaths;
    }

    private static void findMaxSum(TreeNode root, int curr, Maximum max) {
        if(root == null) {
            return;
        }

        curr+=root.data;
        if(root.left == null && root.right == null) {
            if(curr > max.maxno) {
                max.maxno = curr;
            }
        }
        findMaxSum(root.left, curr, max);
        findMaxSum(root.right, curr, max);
    }

    public static void helper(TreeNode root, int sum, List<Integer> currentPath,
                              List<List<Integer>> allPaths, int level) {

        StringBuilder tab = new StringBuilder("\t");
        for(int i=0;i<level;i++) {
            tab.append("\t");
        }
        System.out.println(tab+"helper "+ root +" "+sum+" "+currentPath);


        if(root == null) {
            return;
        }

        currentPath.add(root.data);

        if(root.data == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            helper(root.left, sum-root.data, currentPath, allPaths, level+1);
            helper(root.right, sum-root.data, currentPath, allPaths, level+1);
        }

        // remove the current node from the path to backtrack, 
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void giveAllPaths(TreeNode root, List<Integer> currentPath,
                                    List<List<Integer>> allPaths) {
        if(root == null)
            return;

        currentPath.add(root.data);
        if(root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        }

        giveAllPaths(root.left, currentPath, allPaths);
        giveAllPaths(root.right, currentPath, allPaths);
        currentPath.remove(currentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        int sum = 12;
        List<List<Integer>> result = AllPathsForSum.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}

