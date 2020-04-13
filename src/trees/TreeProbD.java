package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeProbD {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.left.right = new TreeNode(8);

        TreeProbD tree = new TreeProbD();
//        tree.leftViewRecursive(node, 1);
//        System.out.println();
//        tree.rightViewRecursive(node, 1);
//        System.out.println();
//        tree.leftViewOfBinaryTree(node);
//        System.out.println();
//        tree.rightViewOfBinaryTree(node);
        System.out.println(tree.countOfleafNode(node));
        System.out.println(tree.countOfleafNode2(node));
    }


    private int maxLevel = 0;
    private void leftViewRecursive(TreeNode node,int level) {
        if(node == null) {
            return;
        }
        if(maxLevel < level) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }
        leftViewRecursive(node.left, level + 1);
        leftViewRecursive(node.right, level + 1);
    }

    private int maxLvl=0;
    private void rightViewRecursive(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(maxLvl < level) {
            System.out.print(node.data + " ");
            maxLvl = level;
        }
        rightViewRecursive(node.right, level + 1);
        rightViewRecursive(node.left, level+1);
    }

    public void leftViewOfBinaryTree(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while(queue.size() > 0) {
                int count = queue.size();
                int queueCount = queue.size();
                //no. of nodes present in the particular level / count of children nodes of prev node,
                // so count == 0 print the first elem.
                while(count > 0) {
                    TreeNode node = queue.remove();

                    if (count == queueCount)
                        System.out.print(node.data + " ");

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    count--;
                }
                System.out.println();
            }
        }
    }

    public void rightViewOfBinaryTree(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while(queue.size() > 0) {
                int count = queue.size();
                //no. of nodes present in the particular level / count of children nodes of prev node,
                // so isn't it obvious? when count == 1 print the last elem at the particular level
                while(count > 0) {
                    TreeNode node = queue.remove();

                    if (count == 1)
                        System.out.print(node.data + " ");

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    count--;
                }
                System.out.println();
            }
        }
    }

    int count = 0;
    public int countOfleafNode(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = countOfleafNode(node.left);
        int right = countOfleafNode(node.right);

        if(left == 0 && right == 0) {
            count++;
        }

        return count;
    }

    public int countOfleafNode2(TreeNode node) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;

        int left = countOfleafNode2(node.left);
        int right = countOfleafNode2(node.right);

        return (left + right);
    }
}
