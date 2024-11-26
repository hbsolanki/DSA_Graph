package Traversals;

import Storing.AdjancencyList;
import Storing.AdjancencyList.Edge;
import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        AdjancencyList aList = new AdjancencyList();
        
        ArrayList<Edge>[] graph = new ArrayList[7];
        aList.createGraph(graph);
        bfs(graph);
    }
    
    public static void bfs(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean visited[]=new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(graph[0].get(0).src); //source
        
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }

    }
}
