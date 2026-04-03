class Solution {
    public boolean isValidSudoku(char[][] board) {
        int R = board.length;
        int C = board[0].length;

        Map<String, Set<Character>> boxSetMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();

        for (int i = 0; i < R; i++) {
            rowMap.putIfAbsent(i, new HashSet<>());
            Set<Character> rowSet = rowMap.get(i);
            for (int j = 0; j < C; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;

                if (rowSet.contains(curr)) {
                    return false;
                }
                rowSet.add(curr);

                colMap.putIfAbsent(j, new HashSet<>());
                Set<Character> colSet = colMap.get(j);
                if (colSet.contains(curr)) {
                    return false;
                }
                colSet.add(curr);

                int I = i / 3;
                int J = j / 3;
                String boxKey = getKey(I, J);
                boxSetMap.putIfAbsent(boxKey, new HashSet<>());
                Set<Character> boxSet = boxSetMap.get(boxKey);
                if (boxSet.contains(curr)) {
                    return false;
                }
                boxSet.add(curr);
            }
        }

        return true;
    }

    private String getKey(int i, int j) {
        return new String(new char[] {(char) (i + '0'), '-', (char) (j + '0')});
    }
}
