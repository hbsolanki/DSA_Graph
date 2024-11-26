package Storing;

public class AdjancencyMetrix {
    
    public static void main(String[] args) {
        int vertex = 7;
        int graph[][] = new int[vertex][vertex];
        createGraph(graph);

    }

    public static void createGraph(int[][] graph) {  
        graph[0][2] = 2;

        graph[1][2]=10;
        graph[1][3]=1;

        graph[2][0] = 2;
        graph[2][1] = 10;
        graph[2][3] = -1;

        graph[3][1] = 1;
        graph[3][2] = -1;
    }
    

}
