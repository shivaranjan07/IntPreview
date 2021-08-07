package graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class KruskalMST {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Node> adj = new ArrayList<>(v);

        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        kruskal(adj, v);

    }

    /**
     * sort the adjacency list based on weight
     * pick the Node(u, v, weight), if they belong to different component, join them
     * **add new Node to mst line.no 47
     * */
    private static void kruskal(ArrayList<Node> adj, int n) {
        adj.sort(Comparator.comparing(Node::getWeight));
        System.out.println("adj "+adj.toString());

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0;i<n;i++) {
            parent[i]=i;
        }

        int costMst = 0;
        ArrayList<Node> mst = new ArrayList<>(n);

        // get each Node (u, v, weight) since it is sorted based on weight, you will be picking min edge weight
        for(Node neigh:adj) {
            int u = neigh.getU();
            int v = neigh.getV();
            if(findParent(u, parent) != findParent(v, parent)) {
                costMst+=neigh.getWeight(); // add the weight of edge to cost
                mst.add(neigh);
                unionByRank(u, v, parent, rank);
            }
        }

        System.out.println("cost "+costMst);

        System.out.println(mst.toString());
        for(Node neigh:mst) {
            System.out.println(neigh.getU() +" -> "+neigh.getV());
        }
    }

    public static int findParent(int p, int[] parent) {
        if(p==parent[p]) {
            return p;
        }
        parent[p] = findParent(parent[p], parent);
        return parent[p];
    }

    public static void unionByRank(int p, int q, int[] parent, int[] rank) {
        int rootP = findParent(p, parent);
        int rootQ = findParent(q, parent);

        if(rootP == rootQ) return; // both have same parent

        if(rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootQ] = rootP;
            if(rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
    }
}
