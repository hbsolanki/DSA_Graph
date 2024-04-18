import java.util.*;

class TopologySorting {

    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void topSortDFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortDFSUtil(graph, i, vis, s);
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
    
    public static void topSortDFSUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortDFSUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }


    public static void calInDeg(ArrayList<Edge> graph[], int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
        
    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calInDeg(graph, inDeg);

        for (int i = 0; i < graph.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        topSortDFS(graph);
        topSortBFS(graph);
    }
    
}
