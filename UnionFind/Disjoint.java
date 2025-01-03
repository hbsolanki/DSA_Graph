package UnionFind;

class Disjoint {
    static int parent[];
    static int rank[];
    public static void main(String[] args) {
        int n = 8;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);
        System.out.println(find(6));

    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            parent[parA]=parB;
        } else {
            parent[parB] = parA;
        }
    }
}