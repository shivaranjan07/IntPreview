package trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);

        LeafSimilarTrees trees = new LeafSimilarTrees();
        trees.leafSimilar(node, node2);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        helper(root1, leaves1);
        helper(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void helper(TreeNode root,List<Integer> list) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.add(root.data);

        helper(root.left, list);
        helper(root.right, list);
    }
}


