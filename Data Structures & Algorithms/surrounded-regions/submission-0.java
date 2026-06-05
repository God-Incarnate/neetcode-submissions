class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all border O's
        for (int r = 0; r < rows; r++) {

            if (board[r][0] == 'O') {
                queue.offer(new int[]{r, 0});
            }

            if (board[r][cols - 1] == 'O') {
                queue.offer(new int[]{r, cols - 1});
            }
        }

        for (int c = 0; c < cols; c++) {

            if (board[0][c] == 'O') {
                queue.offer(new int[]{0, c});
            }

            if (board[rows - 1][c] == 'O') {
                queue.offer(new int[]{rows - 1, c});
            }
        }

        // BFS to mark safe O's
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            // already visited or not O
            if (r < 0 || r >= rows ||
                c < 0 || c >= cols ||
                board[r][c] != 'O') {
                continue;
            }

            // mark safe
            board[r][c] = 'T';

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                queue.offer(new int[]{nr, nc});
            }
        }

        // Final conversion
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
