package trees;


public class TreeProbA {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);

        TreeProbA tree = new TreeProbA();
//        int level = tree.hightOfTree(node);
//
//        System.out.println("height of a tree is " + level);
//
//        System.out.println("preOrder of Tree ");
//        tree.preOrderRecursive(node);
//
//        System.out.println("\npostOrder of Tree ");
//        tree.postOrderRecursive(node);
//
//        System.out.println("\ninOrder of Tree ");
//        tree.inOrderRecursive(node);

        System.out.println("\nLevelOrder of Tree ");
        tree.levelOrderRecursive(node);
    }

    public int hightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return 1+Math.max(hightOfTree(root.left), hightOfTree(root.right));
        }
    }

    public void preOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void inOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        } else {
            inOrderRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderRecursive(root.right);
        }
    }

    public void postOrderRecursive(TreeNode root) {
        if(root == null) {
            return;
        } else {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * levelOrderTraversal using recursion -> we need two methods,
     * one to print all the nodes at a given level(printGivenLevel)
     * one to print level order traversal of the tree(levelOrderRecursive)
     * */
    private void levelOrderRecursive(TreeNode node) {
        int level = hightOfTree(node);
        //print all the node at each d(level)
        for(int i=1;i<=level;i++) {
            printGivenLevel(node, i);
        }
    }

    private void printGivenLevel(TreeNode node, int level) {

        //if tree is null nothing is there to print
        if(node == null)
            return;
        //if level is 1, then we have only one element to print
        if(level == 1) {
            System.out.print("\n" + node.data + " ");
        } else if(level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}
