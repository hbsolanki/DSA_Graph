package CycleDetection;

import java.util.*;
import Storing.DirectedGraph;
import Storing.DirectedGraph.Edge;

public class CycleDetact {
    
    public static void main(String[] args) {
        new DirectedGraph();
        ArrayList<Edge> graph[] = DirectedGraph.createDirectedGraph();

        System.out.println(cycleDetact(graph));
    }
    
    public static boolean cycleDetact(ArrayList<Edge> graph[]) {
        int V=graph.length;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                return cycleUtil(graph, i, vis, new boolean[V]);
            }
        }

        return false;
    }

    public static boolean cycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            } else if(!vis[e.dest] && cycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
}
