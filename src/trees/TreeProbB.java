package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeProbB {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(7);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        TreeProbB tree = new TreeProbB();

//        tree.inorderIterative(node);
//        System.out.println();
        tree.preOrderIterative(node);
        System.out.println();
        tree.preOrderTwo(node);
//        tree.postOrder(node);
        System.out.println();
//        tree.levelOrderTraversal(node);
    }


    /**
     * Inorder Iterative
     *1. Create an empty stack S
     *2. Initialize current node as root
     *3. push the current node to S and set curr = curr.left until curr is null
     *4. if curr is NULL or stack is not empty then,
     *      a) pop the top item from stack
     *      b) print popped item, set curr = curr.right
     *      c) go to step 3
     * 5. if curr is null and stack is empty then we are done.
     * */
    private void inorderIterative(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Stack<TreeNode> stack = new Stack<>();

            TreeNode curr = root;

            //Traverse the tree
            while(curr != null || !stack.isEmpty()) {
                //go to leftmost node
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                //root node
                curr = stack.pop();
                System.out.print(curr.data + " ");

                //right node
                curr = curr.right;
            }
        }
    }

    //similar to inorder but here we print the node before pushing into stack
    private void preOrderIterative(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Stack<TreeNode> stack = new Stack<>();

            TreeNode curr = root;

            //Traverse the tree
            while(curr != null || !stack.isEmpty()) {
                //go to leftmost node
                while(curr != null) {
                    System.out.print(curr.data + " ");
                    stack.push(curr);
                    curr = curr.left;
                }

                //root node
                curr = stack.pop();

                //right node
                curr = curr.right;
            }
        }
    }


    private void preOrderTwo(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if(curr != null) {
                System.out.print(curr.data + " ");

                if(curr.right != null)
                    stack.push(curr.right);

                if(curr.left != null)
                    stack.push(curr.left);
            }
        }

        System.out.println();

    }


    /**
     * need two stacks
     * 1. push node to stack1
     * 2. while/loop until stack1 is not empty
     *  2.a. pop the node from stack1
     *  2.b. push the node to stack2
     *  2.c. push the left and right children of node to stack1
     * 3. print the stack2
     * */
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();

            s1.push(root);
            while(!s1.isEmpty()) {
                TreeNode node = s1.pop();
                s2.push(node);

                if(node.left != null) {
                    s1.push(node.left);
                }

                if(node.right != null) {
                    s1.push(node.right);
                }
            }

            while(!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                System.out.print(temp.data + " ");
            }
        }
    }

    public void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while(!queue.isEmpty()) {
                int count = queue.size();
                while(count > 0) {
                    TreeNode node = queue.remove();
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

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return (left == null)?right:left;

    }
}
