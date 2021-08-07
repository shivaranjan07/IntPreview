package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {

    public static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0;i<adj.size();i++) {
            System.out.print(i);
            for(int j=0;j<adj.get(i).size();j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }

            System.out.println();
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis) {
        vis[src] = true;
        System.out.print(src + " ");

        for(Integer neighbour: adj.get(src)) {
            if(!vis[neighbour])
                dfs(adj, neighbour, vis);
        }
    }

    public static void connectedComponents(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] vis = new boolean[v];
        int count = 0;
        for(int i=0; i<v;i++) {
            if(!vis[i]) {
                ++count;
                dfs(adj,i,vis);
                System.out.println();
            }
        }
        System.out.println("total connected components "+count);
    }

    /**
     * Bipartite test or 2-coloring prob
     * A bipartite graph also known as bigraph is a special graph such that you cn divide the vertex set into
     * two disjoint sets such that
     * 1. each vertex belongs to exactly one of the 2 sets
     * 2. each edges connects vertices of 2 different sets
     * */
    public static boolean bdfs(ArrayList<ArrayList<Integer>> adj, int src, int col, boolean[] vis, int[] color) {
        vis[src] = true;
        color[src] = col;

        for(Integer n: adj.get(src)) {
            if(!vis[n]) {
                //if u get false from any of children node.. means there is a node, which violates the 2nd constraint
                //if this call tells that graph is not bipartite return false
                if(!bdfs(adj, n, col^1, vis, color)) {
                    return false;
                }
            } else {
                //if both parent and child have same color
                if(color[src] == color[n]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] col = new int[V];
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++)
            if(!vis[i]) {
                if(!bdfs2(adj,i,1,vis,col))
                    return false;
            }

        return true;
    }

    boolean bdfs2(ArrayList<ArrayList<Integer>> adj, int src,
                 int col, boolean[] vis, int[] color) {

        vis[src]=true;
        color[src]=col;

        for(int nei:adj.get(src)) {
            if(!vis[nei]) {
                if(!bdfs2(adj, nei, col^1, vis, color))
                    return false;
            } else {
                if(color[src]==color[nei]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 0, 3);
        addEdges(adj, 2, 4);
        addEdges(adj, 5, 6);

        printGraph(adj);


        System.out.println("dfs traversal of current graph is ");
        boolean[] vis = new boolean[v];
        dfs(adj, 0, vis);

        System.out.println("\nconnected componenets ");
        connectedComponents(adj,v);

        System.out.println("\nis it Bipatite??");
        boolean[] vi = new boolean[v];
        int[] col = new int[v];
        System.out.println(bdfs(adj,0,1,vi,col));


        System.out.println("\n****** BFS ********");
        bfs(adj, 0);

    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int src) {
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            System.out.print(curr + " ");
            for(int neigh: adj.get(curr)) {
                if(!vis[neigh]) {
                    queue.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
    }
}
