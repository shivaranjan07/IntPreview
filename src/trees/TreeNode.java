package trees;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public int hightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return 1+Math.max(hightOfTree(root.left), hightOfTree(root.right));
        }
    }

    private List<Integer> list = new ArrayList<>();
    public void print(TreeNode node) {
        int height = hightOfTree(node);
        for(int i=1;i<=height;i++)
            helper(node, i);

        System.out.println(list);
        list = new ArrayList<>();
    }

    private void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        } else if(level == 1) {
            list.add(node.data);
        } else {
            helper(node.left, level-1);
            helper(node.right, level-1);
        }
    }
}
