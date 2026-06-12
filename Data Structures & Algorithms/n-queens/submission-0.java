class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0, board, cols, diag1, diag2);

        return result;
    }

    private void backtrack(
            int row,
            char[][] board,
            Set<Integer> cols,
            Set<Integer> diag1,
            Set<Integer> diag2) {

        int n = board.length;

        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col)
                    || diag1.contains(row - col)
                    || diag2.contains(row + col)) {
                continue;
            }

            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(row + 1,
                    board,
                    cols,
                    diag1,
                    diag2);

            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }

    private List<String> buildBoard(char[][] board) {

        List<String> solution = new ArrayList<>();

        for (char[] row : board) {
            solution.add(new String(row));
        }

        return solution;
    }
}
