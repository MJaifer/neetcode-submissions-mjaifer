class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    nums++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return nums;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int[] dRow = new int[] {1, 0, -1, 0};
        int[] dCol = new int[] {0, 1, 0, -1};

        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int adjRow = i + dRow[d];
            int adjCol = j + dCol[d];
            
            // out of bounds
            if (adjRow < 0 || adjRow >= grid.length) continue;
            if (adjCol < 0 || adjCol >= grid[0].length) continue;

            if (grid[adjRow][adjCol] == '0' || visited[adjRow][adjCol]) continue;

            dfs(adjRow, adjCol, grid, visited);
        }
    }
}
