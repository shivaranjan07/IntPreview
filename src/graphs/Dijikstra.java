package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Dijikstra {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<Pair>());
        }

        // graph contains nodes from 1 to v
        addEdges(adj,0, 1, 2);
        addEdges(adj,1, 2, 4);
        addEdges(adj,0, 3, 1);
        addEdges(adj,3, 2, 3);
        addEdges(adj,1, 4, 5);
        addEdges(adj,2, 4, 1);

        displayGraph(adj, v);
        
        int src = 0;
        shortestPathWithWeight(adj, src, v);
    }

    public static void displayGraph(ArrayList<ArrayList<Pair>> adj, int v) {
        for(int i=0;i<v;i++) {
            System.out.print(i+1 + "-> ");
            for(Pair neigh:adj.get(i)) {
                System.out.print("("+(neigh.getV()+1)+", "+neigh.getWeight()+") ");
            }
            System.out.println("");
        }
    }

    public static void addEdges(ArrayList<ArrayList<Pair>> adj, int node, int edge, int weight) {
        adj.get(node).add(new Pair(edge, weight));
        adj.get(edge).add(new Pair(node, weight));
    }

    private static void shortestPathWithWeight(ArrayList<ArrayList<Pair>> adj, int src, int v) {
        //1. create distance Array and fill it with Large values
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src]=0;

        // initiate a priority queue and add source
        Comparator<Pair> comparator = Comparator.comparing(Pair::getWeight);
        PriorityQueue<Pair> pq = new PriorityQueue<>(v, comparator);
        pq.add(new Pair(src, 0));


        // if newDistance < distance of neigh, change the distance of neigh
        // and add neigh node and latest weight
        int newDistance=0;
        while(pq.size() > 0) {
            Pair node = pq.poll();
            for(Pair neigh: adj.get(node.getV())) {
                newDistance = dist[node.getV()]+neigh.getWeight();
                if(newDistance < dist[neigh.getV()]) {
                    dist[neigh.getV()] = newDistance;
                    pq.add(new Pair(neigh.getV(), dist[neigh.getV()]));
                }
            }
        }

        //4.display the queue
        Arrays.stream(dist).forEach(i -> System.out.print(i+" "));
    }
}
