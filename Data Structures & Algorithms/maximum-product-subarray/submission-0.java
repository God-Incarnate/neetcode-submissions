class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            // if negative, swap
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr,
                               curr * maxProd);

            minProd = Math.min(curr,
                               curr * minProd);

            result = Math.max(result, maxProd);
        }

        return result;
    }
}