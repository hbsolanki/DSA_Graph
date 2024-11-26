package Storing;

import java.util.*;

public class EdgeList {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(0, 2, 2));

        graph.add(new Edge(1, 2, 10));
        graph.add(new Edge(1, 3, 0));

        graph.add(new Edge(2, 0, 2));
        graph.add(new Edge(2, 1, 10));
        graph.add(new Edge(2, 3, -1));

        graph.add(new Edge(3, 1, 0));
        graph.add(new Edge(3, 2, -1));
    }
}
