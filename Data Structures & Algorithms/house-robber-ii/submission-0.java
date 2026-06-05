class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int sum1=helper(nums,0,n-2);
        int sum2=helper(nums,1,n-1);
        return Math.max(sum1,sum2);
    }
    private int helper(int[] nums,int start,int end){
        int prev1=0;
        int prev2=0;
        for(int i=start;i<=end;i++){
            int cur=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}