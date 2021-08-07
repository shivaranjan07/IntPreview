package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GTDirectedWithWeight {
    int v;
    ArrayList<ArrayList<Pair>> adj;

    public GTDirectedWithWeight(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<Pair>());
        }
    }

    public ArrayList<ArrayList<Pair>> getAdjacencyList() {
        return adj;
    }

    public void addEdges(int node, int edge, int weight) {
        adj.get(node).add(new Pair(edge, weight));
    }

    public void displayGraph() {
        for(int i=0;i<v;i++) {
            System.out.print(i + "-> ");
            for(Pair neigh:adj.get(i)) {
                System.out.print("("+neigh.getV()+", "+neigh.getWeight()+") ");
            }
            System.out.println("");
        }
    }

    public void topologicalSort(Stack<Integer> stack) {
        boolean[] vis = new boolean[this.v];
        for(int i=0;i<this.v;i++) {
            if(!vis[i])
                dfs(i, vis, stack);
        }
    }

    private void dfs(int src, boolean[] vis, Stack<Integer> stack) {
        vis[src]=true;
        for(Pair neighbor:this.adj.get(src)) {
            if(!vis[neighbor.getV()]) {
                dfs(neighbor.getV(), vis, stack);
            }
        }
        stack.push(src);
    }
}
