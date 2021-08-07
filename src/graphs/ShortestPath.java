package graphs;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        int v=9;//no of vertices
        int src = 0;
        GraphTemplate graph = new GraphTemplate(v);
        ArrayList<ArrayList<Integer>> adj = graph.getAdjacencyList();

        graph.addEdges(0, 1, true);
        graph.addEdges(0, 3, true);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(3, 4, true);
        graph.addEdges(4, 5, true);
        graph.addEdges(2, 6, true);
        graph.addEdges(5, 6, true);
        graph.addEdges(6, 7, true);
        graph.addEdges(6, 8, true);
        graph.addEdges(8, 7, true);

        shortestDistanceUndirectedGraph(adj, v, src);
        System.out.println("");

        int n = 6; // no of nodes
        GTDirectedWithWeight graph2 = new GTDirectedWithWeight(6);
        ArrayList<ArrayList<Pair>> adjList = graph2.getAdjacencyList();
        graph2.addEdges(0, 1, 2);
        graph2.addEdges(0, 4, 1);
        graph2.addEdges(1, 2, 3);
        graph2.addEdges(2, 3, 6);
        graph2.addEdges(4, 2, 2);
        graph2.addEdges(4, 5, 4);
        graph2.addEdges(5, 3, 1);

        shortestDistanceDirectedGraph(graph2, adjList, n, src);
    }

    private static void shortestDistanceDirectedGraph(GTDirectedWithWeight graph2, ArrayList<ArrayList<Pair>> adjList,
                                                      int n, int src) {
        //1. create distance Array and fill it with Large values
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //2. find topological sort of graph
        Stack<Integer> stack = new Stack<>();
        graph2.topologicalSort(stack);

        dist[src] = 0;

        //3. check dist[node] != Integer.MAX_VALUE because we need to find shortest path from src to other nodes,
        // and only distance of src node is not IMV in the beginning
        int newDistance;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(node != Integer.MAX_VALUE) {
                for(Pair neigh: adjList.get(node)) {
                    newDistance = dist[node]+neigh.getWeight();
                    if(newDistance < dist[neigh.getV()]) {
                        dist[neigh.getV()] = newDistance;
                    }
                }
            }
        }

        //4.display the queue
        Arrays.stream(dist).forEach(i -> System.out.print(i+" "));
    }

    /**
     * Shortest Distance from a source node(0 here) to destination in a undirected graph
     * basic BFS -> assume each edge has weight 1
     * keep the distance array with every elem equal to Integer.MAX_VALUE or large number
     * make dist of source node = 0 dist[src]=0 and add it to queue
     * if dist[source]+1 < dist[neigh] then change the distance of neighbor and add it to queue
     *
     * distance of 3 is 1 from 0(source node), neighbors of 3 is 0 and 4
     *  +1
     *    ↘ 3 -> 0 1(dist[src])+1 = 2 dist[0] is already 0, so the newDistance is not considered
     *        ↘  4 1+1 = 2 dist[4] is Integer.MAX_VALUE(or newDistance < dist[4]) so dist[4]=newDistance
     *
     * */
     public static void shortestDistanceUndirectedGraph(ArrayList<ArrayList<Integer>> adj, int v, int src){
         //1. create distance Array and fill it with Large values
         int[] dist = new int[v];
         Arrays.fill(dist, Integer.MAX_VALUE);

         //2. create a queue and add the src node
         Queue<Integer> queue = new LinkedList<>();
         dist[src] = 0;
         queue.add(src);

         //3.bfs
         while(!queue.isEmpty()) {
             Integer node = queue.poll();

             //traverse your neighbors
             for(int neigh:adj.get(node)) {
                 int newDistance = dist[node]+1;
                 if(newDistance < dist[neigh]) {
                     dist[neigh] = newDistance;
                     queue.add(neigh);
                 }
             }
         }

         //4.display the queue
         Arrays.stream(dist).forEach(i -> System.out.print(i+" "));
     }

}
