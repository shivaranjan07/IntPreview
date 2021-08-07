package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Topological Sort
 * Graph must Directed & Acyclic (DAG)
 * it is a linear ordering of vertices such that if there is an edge u -> v, u appears before v in that ordering
 * */
public class TopologicalSort {
    public static void main(String[] args) {
        int v=6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdges(adj, 5, 0);
        addEdges(adj, 5, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 4, 0);
        addEdges(adj, 4, 1);
        addEdges(adj, 3, 1);

        topoSortbyDFS(adj, v);
        System.out.println("");
        topoSortbyBFS(adj, v);
    }

    /**
     * Kahn's Algorithm - BFS
     * use the in-degree of node to find the ordering
     * add all the nodes into queue, whose in-degree is 0,
     * poll the node remove the outgoing edges from neighbors in-degree[neighbors]--
     * if the in-degree of the node is 0 add it to queue
     * you can also find if the directed graph is cyclic or not using kahn's algo
     * */
    private static void topoSortbyBFS(ArrayList<ArrayList<Integer>> adj, int v) {
        //1. calculate in-degree of node
        int[] inDegree = new int[v];
        for(int i=0;i<v;i++) {
            for(int neighbor:adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        //2. BFS -> add all the node whose in-degree is 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<v;i++) {
            if(inDegree[i]==0) {
                queue.add(i);
            }
        }
        // count to find if graph is acyclic or not, if count == v, there is no cycle
        int count=0;
        while(!queue.isEmpty()) {
            Integer src = queue.poll();
            System.out.print(src+" ");
            count++;
            for(int neighbor:adj.get(src)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("count "+count);

    }

    /**
     * for the given graph
     * 0 is the first node, it has no neighbors so it will be added to stack
     * 1 -> 1 has no neighbors it will be added to stack
     * vis[0]=vis[1]=true;
     * 2 has 3 as it's neighbor, dfs call for 3 will happen
     * 3 has 1 as it's neighbor, but 1 is already visited so 3 finishes, and it is added into stack
     * 2 has no neighbors after 3 so 2 is added to stack
     * for 4 and 5, their neighbors are already visited so they will be added to stack
     * stack is not auxiliary stack/space
     * stack value 5 4 2 3 1 0
     * */
    private static void topoSortbyDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!vis[i])
                topologicalSortUsingDfs(adj, vis, i, stack);
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() +" ");
        }
    }

    private static void topologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src,
                                                Stack<Integer> stack) {
        vis[src]=true;
        for(int neighbor:adj.get(src)) {
            if(!vis[neighbor]) {
                topologicalSortUsingDfs(adj, vis, neighbor, stack);
            }
        }
        stack.push(src);
    }

    private static void addEdges(ArrayList<ArrayList<Integer>> adj, int node, int edge) {
        adj.get(node).add(edge);
    }


}
