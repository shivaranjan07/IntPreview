package trees;

import java.util.HashMap;
import java.util.Map;

public class TreeProbG {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }

        index = postorder.length-1;
        return helper(inorder, postorder, 0, inorder.length-1, map);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int low, int high, Map<Integer, Integer> map) {
        if(low > high) {
            return null;
        }


        int val = postorder[index--];

        TreeNode root = new TreeNode(val);
        int ir = map.get(val);

        root.right = helper(inorder, postorder, ir+1, high, map);
        root.left = helper(inorder, postorder, low, ir-1, map);

        return root;
    }

    //index = 0;
    public TreeNode helper2(int[] preorder, int[] inorder, int low, int high, Map<Integer, Integer> map) {
        if(low > high) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        int ir = map.get(val);
        root.left = helper2(preorder, inorder, low, ir-1, map);
        root.right = helper2(preorder, inorder, ir+1, high, map);

        return root;
    }
}
