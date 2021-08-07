package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeProbE {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
//        node.right.left.right = new TreeNode(8);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);

        TreeProbE tree = new TreeProbE();
//        node.print(node);
//        TreeNode result = tree.invertRecursively(node);
//        node.print(result);
//        TreeNode res = tree.invertIteratively(node);
//        node.print(res);
//        int diameter = tree.diameterOfTree(node);
//        int diameter2 = tree.diameterOfBinaryTree(node);
//        tree.tiltOfBinaryTree(node);
//        System.out.println("tilt " + tree.total);

        maxSum(node,0);
        System.out.println(tree.max+ "");
    }

    int ans = 0;
    private int diameterOfBinaryTree(TreeNode node) {
        ans = 1;
        dfs(node);
        return ans-1;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = dfs(root.left);
            int right = dfs(root. right);

            ans = Math.max(ans, left+right+1);

            return 1 + Math.max(left,right);
        }
    }

    private TreeNode invertRecursively(TreeNode node) {
        if(node == null) {
            return null;
        } else {
            TreeNode left = invertRecursively(node.left);
            TreeNode right = invertRecursively(node.right);

            node.right = left;
            node.left = right;
        }
        return node;
    }

    private TreeNode invertIteratively(TreeNode node) {
        if(node == null) {
            return null;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);

            while(!queue.isEmpty()) {
                TreeNode curr = queue.remove();
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                if(curr.left != null) {
                    queue.add(curr.left);
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return node;
    }

    class Group {
        int diameter;
        int height;

        Group(int d, int h) {
            diameter = d;
            height = h;
        }
    }

    private int diameterOfTree(TreeNode node) {
        Group d = helper(node);
        return d.diameter;
    }

    private Group helper(TreeNode root) {
        if(root == null) {
            return new Group(0,0);
        } else {
            Group left = helper(root.left);
            Group right = helper(root.right);

            int diam = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);
            return new Group(diam, Math.max(left.height , right.height) + 1);
        }
    }



    /**
     *
     * Given a binary tree, return the tilt of the whole tree.
     *
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
     *
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     * */
    int total = 0;
    public int tiltOfBinaryTree(TreeNode root) {
        help(root, 1);
        return total;
    }

    public int help(TreeNode root, int level) {
        String tab = "\t";

        for(int i=1;i<=level;i++) {
            tab+="\t";
        }

        if(root == null)
            return 0;

        System.out.println(tab + "help( "+ root.data +" )");

        int left = help(root.left, level + 1);
        int right = help(root.right, level + 1);

        total += Math.abs(left-right);

        return left+right+root.data;
    }

    static int max = Integer.MIN_VALUE;
    public static void maxSum(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        sum+=root.data;

        if(root.left == null && root.right == null && sum > max) {
            max = sum;
            return;
        } else {
            maxSum(root.left, sum);
            maxSum(root.right, sum);
        }

    }

}

/**
 *
 * class TreeDiameter {
 *   private static int diameter = 0;
 *   public static int findDiameter(TreeNode root) {
 *     int height = helper(root);
 *     return diameter;
 *   }
 *
 *   public static int helper(TreeNode root) {
 *     if(root == null) {
 *       return 0;
 *     }
 *
 *     int left = helper(root.left);
 *     int right = helper(root.right);
 *
 *     // if the current node doesn't have a left or right subtree, we can't have
 *     // a path passing through it, since we need a leaf node on each side
 *     if(root.left != 0 && root.right != 0) {
 *       // int d = (left + right) + 1;
 *       diameter = Math.max(diameter, left+right+1);
 *     }
 *
 *     return Math.max(left, right) + 1;
 *
 *   }
 * */
