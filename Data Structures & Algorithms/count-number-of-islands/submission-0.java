class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0'; // mark visited

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : directions) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];

                // check bounds + land
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length 
                    && grid[ni][nj] == '1') {

                    queue.offer(new int[]{ni, nj});
                    grid[ni][nj] = '0'; // mark visited
                }
            }
        }
    }
}
