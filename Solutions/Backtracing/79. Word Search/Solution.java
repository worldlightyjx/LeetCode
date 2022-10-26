class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, 0, i, j, visited, word)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, int idx, int x, int y, int[][] visited, String word) {
        if (idx == word.length()) {
            return true;
        }
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y] == 1
                || word.charAt(idx) != board[x][y]) {
            return false;
        }

        visited[x][y] = 1;
        boolean res = dfs(board, idx + 1, x + 1, y, visited, word)
                || dfs(board, idx + 1, x - 1, y, visited, word)
                || dfs(board, idx + 1, x, y + 1, visited, word)
                || dfs(board, idx + 1, x, y - 1, visited, word);

        visited[x][y] = 0;

        return res;
    }
}