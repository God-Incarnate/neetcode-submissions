class Solution {
    public int[] twoSum(int[] nums, int target) {
     int n = nums.length;
    int[][] arr = new int[n][2];
    
    for (int i = 0; i < n; i++) {
        arr[i][0] = nums[i];
        arr[i][1] = i;
    }
    
    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    
    int left = 0, right = n - 1;
    
    while (left < right) {
        int sum = arr[left][0] + arr[right][0];
        
        if (sum == target) {
            int i = arr[left][1];
            int j = arr[right][1];
            return new int[]{Math.min(i, j), Math.max(i, j)};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return new int[]{-1, -1};
    }
}
