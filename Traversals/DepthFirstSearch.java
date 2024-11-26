package Traversals;

import Storing.AdjancencyList;
import Storing.AdjancencyList.Edge;
import java.util.*;

class DepthFirstSearch {
    
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        new AdjancencyList().createGraph(graph);
        dfs(graph,graph[0].get(0).src,new boolean[V]);
    }
    
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean []vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    
}
