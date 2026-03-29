class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[][] indegree = new int[R][C];
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // find indegrees
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int[] dir: dirs) {
                    int newR = r + dir[0], newC = c + dir[1];

                    // skip out of bounds
                    if (newR < 0 || newR == R || newC < 0 || newC == C) {
                        continue;
                    }
                    
                    // graph connect smaller cell to larger cell
                    // so add indegree to current cell if adjCell is strictly less than current cell
                    if (matrix[r][c] > matrix[newR][newC]) {
                        indegree[r][c]++;
                    }
                }
            }
        }

        // start topological sort from nodes having zero indegree
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (indegree[r][c] == 0) {
                    q.add(new int[] {r,c});
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] adj = q.remove();
                int r = adj[0], c = adj[1];

                for (int[] dir: dirs) {
                    int newR = r + dir[0], newC = c + dir[1];
                    if (newR < 0 || newR == R || newC < 0 || newC == C) {
                        continue;
                    }
                    // graph relation is from smaller cell to larger cell
                    // so if current cell mat[r][c] is smaller than adj cell, we have a valid edge
                    // remove it from the indegree
                    if (matrix[r][c] < matrix[newR][newC]) {
                        indegree[newR][newC]--;
                        if (indegree[newR][newC] == 0) {
                            q.add(new int[] {newR, newC});
                        }
                    }
                }
            }
        }

        return ans;
    }
}
