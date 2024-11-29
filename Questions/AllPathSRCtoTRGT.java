package Questions;

import Storing.DirectedGraph;
import Storing.DirectedGraph.Edge;
import java.util.*;

class AllPathSRCtoTRGT {
    
    public static void main(String[] args) {

        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // new AdjancencyList().createGraph(graph);
        // allPathFromSourceToTarget(graph, new boolean[V], 0  , "", 6);
        ArrayList<Edge> graph[] = new DirectedGraph().createDirectedGraph();
        printALlPath(graph, 0, 5, "");
    }
    
    //Undirected
    public static void allPathFromSourceToTarget(ArrayList<Edge> graph[], boolean vis[], int curr, String path,
            int target) {

        if (curr == target) {
            System.out.println(path + " " + target);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                vis[curr] = true;
                allPathFromSourceToTarget(graph, vis, e.dest, path + " " + curr, target);
                vis[curr] = false;
            }
        }

    }
    
     //Directed
    public static void printALlPath(ArrayList<Edge> graph[],int src,int dest,String path){

        if (src == dest) {
            System.out.println(path + " " + dest);
        }
        
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printALlPath(graph, e.dest, dest, path+" "+src);
        }

    }

}
