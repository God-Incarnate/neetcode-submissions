class Solution {

    private static final int[][] DIRS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void islandsAndTreasure(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        bfs(queue, rooms, m, n);
    }

    private void bfs(Queue<int[]> queue, int[][] rooms, int m, int n) {

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] dir : DIRS) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n
                    || rooms[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[nr][nc] = rooms[row][col] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}