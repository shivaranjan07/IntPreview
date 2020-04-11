package trees;

import java.util.*;

public class TreeProbC {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.left.right = new TreeNode(8);

        TreeProbC tree = new TreeProbC();
        tree.verticalTraversal(node);
    }

    /**
     * we will store node value and distance in queue(for level Order Traversal) and in TreeMap to print
     * the vertical order based on horizontal distance
     * */
    class Obj {
        TreeNode node;
        int distance;

        public Obj(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public void verticalTraversal(TreeNode root) {
        if(root == null) {
            return;
        } else {
            TreeMap<Integer, List<TreeNode>> map = new TreeMap<>();
            Queue<Obj> queue = new LinkedList<>();

            //add the root to queue
            queue.add(new Obj(root, 0));

            while(!queue.isEmpty()) {
                Obj object = queue.remove();

//                System.out.print(object.node.data + " ");

                if(map.containsKey(object.distance)) {
                    map.get(object.distance).add(object.node);
                } else {
                    map.put(object.distance, new LinkedList<>());
                    map.get(object.distance).add(object.node);
                }

                //for left child distance will be -1 of root
                if(object.node.left != null) {
                    queue.add(new Obj(object.node.left, object.distance-1));
                }

                if(object.node.right != null) {
                    queue.add(new Obj(object.node.right, object.distance+1));
                }
            }

            map.forEach((k,v) -> {
                v.forEach((node) -> System.out.print(node.data+ " "));
                System.out.println();
            });

//            for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
//                for(TreeNode node:entry.getValue()) {
//                    System.out.print(node.data + " ");
//                }
//                System.out.println();
//            }
        }
    }
}
