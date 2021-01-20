package graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertices;
    private List<Integer>[] graphV; //like int[] I need to have an arr which can contain a list of Integers

    public Graph(int v) {
        vertices = v;
        graphV = new LinkedList[vertices];

        for(int i=0;i<vertices;i++) {
            graphV[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        graphV[u].add(v);
        graphV[v].add(u);
    }

    public void printGraph() {
        for(int i=0;i<vertices;i++) {
            System.out.print(i);
            for(int node: graphV[i]) {
                System.out.print("-> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);

        graph.printGraph();
    }
}
