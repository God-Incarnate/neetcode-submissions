class Solution {
    public int findDuplicate(int[] nums) {
        for( int i=0;i<nums.length;i++){
            int pos=Math.abs(nums[i]);
            if(nums[pos]<0) return pos;
            nums[pos]*=-1;
        }
        return -1;
    }
}
