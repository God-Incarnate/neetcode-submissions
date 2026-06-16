class Solution {

    private static final int[][] DIRS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void islandsAndTreasure(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) {
                    dfs(rooms, r, c, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int row, int col, int distance) {

        int m = rooms.length;
        int n = rooms[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }

        if (rooms[row][col] < distance) {
            return;
        }

        rooms[row][col] = distance;

        for (int[] dir : DIRS) {
            dfs(
                rooms,
                row + dir[0],
                col + dir[1],
                distance + 1
            );
        }
    }
}