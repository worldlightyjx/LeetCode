class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] nbd = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLive(board, i, j);
                if (board[i][j] == 1) {
                    if (live != 2 && live != 3) {
                        nbd[i][j] = 0;
                    } else {
                        nbd[i][j] = board[i][j];
                    }
                } else {
                    if (live == 3) {
                        nbd[i][j] = 1;
                    } else {
                        nbd[i][j] = board[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nbd[i][j];
            }
        }

    }

    private int countLive(int[][] bd, int x, int y) {
        int live = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= bd.length || (i == x && j == y) || j < 0 || j >= bd[0].length) {
                    continue;
                }
                if (bd[i][j] == 1) {
                    live++;
                }
            }
        }
        return live;
    }
}