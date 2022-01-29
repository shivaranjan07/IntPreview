package graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PrintAllTopoOrderings {
    public static void printOrders(int tasks, int[][] pre) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<tasks;i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[tasks];
        for(int i=0;i<pre.length;i++) {
            graph.get(pre[i][0]).add(pre[i][1]);
            indegree[pre[i][1]]++;
        }

        Queue<Integer> sources = new LinkedList<>();
        for(int i=0;i<tasks;i++) {
            if(indegree[i] == 0) {
                sources.offer(i);
            }
        }

        printAllTopologicalSorts(graph, indegree, sources, list);

    }

    private static void printAllTopologicalSorts(ArrayList<ArrayList<Integer>> graph,
                                                 int[] inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                // get the node's children to decrement their in-degrees
                ArrayList<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree[child]--;
                    if (inDegree[child] == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree[child]++;
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.length)
            System.out.println(sortedOrder);
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    public static void main(String[] args) {
//        PrintAllTopoOrderings.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
//        System.out.println();

        PrintAllTopoOrderings.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

//        PrintAllTopoOrderings.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
//                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
//        System.out.println();
    }
}
