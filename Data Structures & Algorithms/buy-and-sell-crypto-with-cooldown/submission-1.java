class Solution {
    //Backward DP --- bottom up dp

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // Can Buy
            dp[i][1] = Math.max(
                -prices[i] + dp[i + 1][0],
                dp[i + 1][1]
            );

            // Holding Stock
            dp[i][0] = Math.max(
                prices[i] + dp[i + 2][1],
                dp[i + 1][0]
            );
        }

        return dp[0][1];
    }
}