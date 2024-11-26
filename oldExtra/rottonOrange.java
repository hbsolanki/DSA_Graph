package oldExtra;
import java.util.*;

class rottonOrange {

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int orangesRotton(int[][] grid) {

        int total = 0, rotton = 0, time = 0;

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;

                    if (grid[i][j] == 2) {
                        q.add(new Pair(i, j));
                    }
                }
            }
        }

        if (total == 0)
            return 0;

        int ni=grid.length;
        int nj=grid[0].length;

        while (!q.isEmpty()) {
            int size = q.size();
            rotton += size;

            if(rotton==total)
                return time;

            time++;

            for (int i = 0; i < size; i++) {
                Pair p = q.remove();

                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.add(new Pair(p.x - 1, p.y));
                }

                if (p.x + 1 < nj && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.add(new Pair(p.x + 1, p.y));
                }

                if (p.y - 1 >= 0 && grid[p.x][p.y-1] == 1) {
                    grid[p.x][p.y-1] = 2;
                    q.add(new Pair(p.x, p.y-1));
                }

                if (p.y +1 <ni && grid[p.x ][p.y+1] == 1) {
                    grid[p.x ][p.y+1] = 2;
                    q.add(new Pair(p.x , p.y+1));
                }

            }
            
        }


        return -1;
    }
    

    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        
        rottonOrange r = new rottonOrange();
        int ans = r.orangesRotton(grid);
        System.out.println(ans);
    }
}
