package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GraphTemplate {
    int v;
    ArrayList<ArrayList<Integer>> adj;

    public GraphTemplate(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return adj;
    }

    public void addEdges(int node, int edge, boolean bi) {
        this.adj.get(node).add(edge);
        if(bi) { // undirected
            this.adj.get(edge).add(node);
        }
    }

    public void displayGraph() {
        for(int i=0;i<v;i++) {
            System.out.print(i + "-> ");
            for(int neigh:adj.get(i)) {
                System.out.print(neigh+" ");
            }
            System.out.println("");
        }
    }

    public Stack<Integer> topologicalSort(int src, boolean[] vis, Stack<Integer> stack) {
        for(int i=0;i<this.v;i++) {
            if(!vis[i])
                dfs(src, vis, stack);
        }
        return  stack;
    }

    private void dfs(int src, boolean[] vis, Stack<Integer> stack) {
        vis[src]=true;
        for(int neighbor:this.adj.get(src)) {
            if(!vis[neighbor]) {
                dfs(neighbor, vis, stack);
            }
        }
        stack.push(src);
    }
}
