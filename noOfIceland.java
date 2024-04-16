class noOfIceland {
    
    public int numIslands(char[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfsFill(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';

            dfsFill(grid, i - 1, j);
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i , j-1);
            dfsFill(grid, i, j+1);
        }
    }

}
