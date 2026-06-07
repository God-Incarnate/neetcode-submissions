class Solution {

    public boolean isInterleave(String s1,
                                String s2,
                                String s3) {

        int m = s1.length();
        int n = s2.length();

        // Length mismatch impossible
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                // Take from s1
                if (i > 0 &&
                    s1.charAt(i - 1) ==
                    s3.charAt(i + j - 1)) {

                    dp[i][j] |= dp[i - 1][j];
                }

                // Take from s2
                if (j > 0 &&
                    s2.charAt(j - 1) ==
                    s3.charAt(i + j - 1)) {

                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}