package trees;


/**
 *Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        BalancedBinaryTree tree = new BalancedBinaryTree();
        System.out.println(tree.isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = height(root.left);
            if(left == -1) {
                return -1; //left tree is unbalanced
            }
            int right = height(root.right);
            if(right == -1) {
                return -1; //right tree is unbalanced
            }
            if(Math.abs(left-right) > 1)
                return -1; //imbalance between the 2 subtrees

            return 1 + Math.max(left, right);
        }
    }
}
