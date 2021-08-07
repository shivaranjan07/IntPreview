package trees;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node next;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        next = null;
        left = null;
        right = null;
    }
}
/**
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Connect {
    //O(1)=> space
    //Perfect binary tree
public Node connect(Node root) {
    Node level_start=root;
    while(level_start!=null){
        Node cur=level_start;
        while(cur!=null){
            if(cur.left!=null) cur.left.next=cur.right;
            if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

            cur=cur.next;
        }
        level_start=level_start.left;
    }
    return root;
}

public Node connect1b(Node root) {
    if(root == null) {
        return root;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
        int count = 0;
        int n = queue.size();
        while(count < n) {
            Node curr = queue.poll();

            if(curr.left != null) {
                queue.add(curr.left);
            }

            if(curr.right != null) {
                queue.add(curr.right);
            }

            if(count < n-1) {
                curr.next = queue.peek();
            } else {
                curr.next = null;
            }

            count++;
        }
    }
    return root;
}

/**
 *                      root 1
 *      1.left = 2                   1.right = 3
 * 2.left = 4 2.right=5                     3.right = 7
 *
 * */
public Node connect2(Node root) {
    Node level_start = root;
    while(root != null) {
        Node temp = new Node(0);
        Node curr = temp;
        while(root != null) {
            if(root.left != null) {
                curr.next = root.left;
                curr = curr.next;
            }

            if(root.right != null) {
                curr.next = root.right;
                curr = curr.next;
            }

            root = root.next;
        }
        root = temp.next;
    }
    return level_start;
}

}
