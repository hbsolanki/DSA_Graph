package Storing;
import java.util.*;

public class DirectedGraph {

    public static class Edge{
        public int src;
        public int dest;
        public int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    
    public static void main(String[] args) {

    }
    
    public static ArrayList<Edge>[] createDirectedGraph() {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));

        graph[1].add(new Edge(1, 2, 5));

        graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge( 2, 4, 4));

        graph[3].add(new Edge(3, 5, 7));

        graph[4].add(new Edge(4, 2, 5));

        graph[4].add(new Edge(5, 4, 7));



        return graph;
    }
}
