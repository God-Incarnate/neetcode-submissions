class Solution {
    public int maxSubArray(int[] nums) {
        int insSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            insSum=Math.max(nums[i],nums[i]+insSum);
            maxSum=Math.max(maxSum,insSum);
        }
        return maxSum;
    }
}