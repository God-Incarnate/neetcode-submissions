class Solution {
    public double myPow(double x, int n) {

        long power = n;

        // handle negative powers
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;

        while (power > 0) {

            // if odd power
            if ((power & 1) == 1) {
                result *= x;
            }

            x *= x;
            power >>= 1;
        }

        return result;
    }
}