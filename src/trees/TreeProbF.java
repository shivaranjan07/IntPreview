package trees;



public class TreeProbF {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(12);
        node.right = new TreeNode(22);
        node.left.right.left = new TreeNode(10);
//        node.right.right = new TreeNode(7);

        TreeNode ans = kthSmallest(node, 3, 1);
        System.out.println(ans.data + " ");
    }

    private static int count=0;
    private static TreeNode kthSmallest(TreeNode root, int k, int level) {
        String tab = "\t";

        for(int i=1;i<=level;i++) {
            tab+="\t";
        }

        System.out.println(tab + "help( "+ (null == root ? null : root.data) +" " + k +" )");

        // base case
        if (root == null)
            return null;


        // search in left subtree
        TreeNode left = kthSmallest(root.left, k, level+1);

        // if k'th smallest is found in left subtree, return it // smallest elem will be usually on left
        if (left != null)
            return left;

        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;

        // else search in right subtree
        return kthSmallest(root.right, k, level+1);
    }
}
