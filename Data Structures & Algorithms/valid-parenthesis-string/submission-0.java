class Solution {

    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                low++;
                high++;
            }
            else if (ch == ')') {

                low--;
                high--;
            }
            else { // '*'

                low--;
                high++;
            }

            // low cannot be negative
            low = Math.max(low, 0);

            // Too many ')'
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}