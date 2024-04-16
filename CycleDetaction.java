import java.util.*;

class CycleDetaction {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

         graph[6].add(new Edge(6, 5, 1));
    }


    public static boolean cycleDetact(ArrayList<Edge> graph[],int v) {
        boolean vis[] = new boolean[v];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && cycleDetactUtil(graph, i, vis, new boolean[v])) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean cycleDetactUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest] && cycleDetactUtil(graph, e.dest, vis, stack))
                return true;
        }
        
        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge> []graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        boolean ans = cycleDetact(graph, V);
        System.out.println(ans);
    }
    
}
