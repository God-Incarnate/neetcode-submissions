class Solution {
    // Recursive + memoization
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return dfs(0, s, memo);
    }

    private int dfs(int index, String s, Integer[] memo) {

        // reached end successfully
        if (index == s.length()) {
            return 1;
        }

        // invalid because numbers can't start with 0
        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        // take one digit
        int ways = dfs(index + 1, s, memo);

        // take two digits if valid
        if (index + 1 < s.length()) {
            int num = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += dfs(index + 2, s, memo);
            }
        }

        return memo[index] = ways;
    }
}