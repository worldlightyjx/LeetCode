class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int time = 0, fresh = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }

                if (grid[i][j] == 1) {
                    fresh += 1;
                }
            }
        }

        if (fresh == 0)
            return 0;

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coo = queue.poll();
                for (int[] dir : dirs) {
                    int nx = coo[0] + dir[0];
                    int ny = coo[1] + dir[1];

                    if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != 1) {
                        continue;
                    }

                    grid[nx][ny] = 2;
                    queue.offer(new int[] { nx, ny });
                    fresh--;
                }
            }

        }

        return fresh == 0 ? time - 1 : -1;

    }
}