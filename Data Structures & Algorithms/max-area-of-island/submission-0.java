class Solution {
    int[][] dirs = new int[][]{
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int area = grid[i][j];
        for (int[] dir: dirs) {
            int dx = dir[0];
            int dy = dir[1];

            int r = i + dx;
            int c = j + dy;

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                continue;
            }
            if (visited[r][c] || grid[r][c] == 0) {
                continue;
            }

            area += dfs(grid, visited, r, c);
        }
        return area;
    }
}
