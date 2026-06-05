class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check first row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // check first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // use first row/col as markers
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // zero rows
        for (int i = 1; i < rows; i++) {

            if (matrix[i][0] == 0) {

                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // zero columns
        for (int j = 1; j < cols; j++) {

            if (matrix[0][j] == 0) {

                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // zero first row
        if (firstRowZero) {

            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // zero first column
        if (firstColZero) {

            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}