package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsMST {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
        }
        // graph contains nodes from 1 to v
        addEdges(adj,0, 1, 2);
        addEdges(adj,1, 2, 3);
        addEdges(adj,0, 3, 6);
        addEdges(adj,1, 3, 8);
        addEdges(adj,1, 4, 5);
        addEdges(adj,2, 4, 7);

        prims(adj, v);
    }

    private static void prims(ArrayList<ArrayList<Pair>> adj, int n) {
        //1. define and fill key, mstSet and parent arrays
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mstSet, false);

        //2. create a min Priority queue -> to get the smallest key node
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, Comparator.comparing(Pair::getWeight));
        key[0]=0;
        pq.add(new Pair(0, key[0]));

        //3. traverse the graph
        // 3.1 get the smallest key node
        // 3.2 set True for mstSet[keyNode]
        // 3.3 traverse the neighbors of keyNode, if key[neighborsValue] value is greater than neighbor's edge weight,
        // change the key[neighborsValue(neighbor.getv())] = neighbors.getWeight()
        // 3.4 set the parent of neighbor = keyNode
        // 3.5 add the neighNode and it's latest keyValue to pq
        for(int i=0;i<n-1;i++) { //n-1 edges
            int u = pq.poll().getV(); //keyNode
            mstSet[u]=true;

            for(Pair neigh:adj.get(u)) {
                int neighNode = neigh.getV();
                if(mstSet[neighNode] == false && neigh.getWeight() < key[neighNode]) {
                    parent[neighNode] = u;
                    key[neighNode] = neigh.getWeight(); //edge weight
                    pq.add(new Pair(neighNode, key[neighNode]));
                }
            }

        }
        // 4. create MST
        for(int i=1;i<n;i++) {
            System.out.println(parent[i]+" -> "+i);
        }

    }

    public static void displayGraph(ArrayList<ArrayList<Pair>> adj, int v) {
        for(int i=0;i<v;i++) {
            System.out.print(i + "-> ");
            for(Pair neigh:adj.get(i)) {
                System.out.print("("+(neigh.getV())+", "+neigh.getWeight()+") ");
            }
            System.out.println("");
        }
    }

    public static void addEdges(ArrayList<ArrayList<Pair>> adj, int node, int edge, int weight) {
        adj.get(node).add(new Pair(edge, weight));
        adj.get(edge).add(new Pair(node, weight));
    }
}
