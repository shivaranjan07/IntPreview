package graphs;

import java.util.*;

public class CloneGraph {
    static class Node2 {
        public int val;
        public List<Node2> neighbors;
        public Node2() {
            val = 0;
            neighbors = new ArrayList<Node2>();
        }
        public Node2(int _val) {
            val = _val;
            neighbors = new ArrayList<Node2>();
        }
        public Node2(int _val, ArrayList<Node2> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node2 cloneGraph(Node2 start) {
        if(start == null) return null;
        HashMap<Node2, Node2> map = new HashMap<>();                      // for each node in graph we create a new node
        map.put(start, new Node2(start.val, new ArrayList<Node2>()));     // add starting node
        Queue<Node2> q = new LinkedList<>();                             // queue for bfs
        q.offer(start);                                                 // add start node to queue
        while(!q.isEmpty()) {                                           // iterate until queue is empty
            Node2 curr = q.poll();                                       // get the first node in queue
            for(Node2 n : curr.neighbors) {                              // for every neighbor of first node
                if(!map.containsKey(n)) {                               // if neighbor not in map
                    map.put(n, new Node2(n.val, new ArrayList<Node2>())); // create new node for neighbor
                    q.offer(n);                                         // also add neighbor to queue
                }
                map.get(curr).neighbors.add(map.get(n));                // add neighbor to list of neighbors of first node
            }
        }
        return map.get(start);                                          // return the duplicate of start node
    }
}
