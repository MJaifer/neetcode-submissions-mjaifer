class Solution {
    int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (index == word.length()-1 && board[i][j] == word.charAt(index)) {
            return true;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        int R = board.length;
        int C = board[0].length;

        visited[i][j] = true;
        
        for (int[] dir: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if (row < 0 || row >= R || col < 0 || col >= C || visited[row][col]) {
                continue;
            }

            if (dfs(board, word, index + 1, row, col, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        
        return false;
    }
}
