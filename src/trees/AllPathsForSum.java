package trees;

import java.util.*;

class AllPathsForSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        helper(root, sum, currentPath, allPaths, 0);
        return allPaths;
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

