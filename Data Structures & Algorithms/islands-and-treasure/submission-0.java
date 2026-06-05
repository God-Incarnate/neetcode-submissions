

class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] d : dirs) {
                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                // valid empty room
                if (ni >= 0 && nj >= 0 && ni < m && nj < n 
                    && rooms[ni][nj] == Integer.MAX_VALUE) {

                    rooms[ni][nj] = rooms[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
    }
}