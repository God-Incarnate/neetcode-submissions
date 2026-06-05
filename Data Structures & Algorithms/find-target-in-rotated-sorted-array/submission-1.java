class Solution {
    public int search(int[] nums, int target) {
    int pivot = findPivot(nums);

    // decide which half to search
    if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
        return binarySearch(nums, pivot, nums.length - 1, target);
    } else {
        return binarySearch(nums, 0, pivot - 1, target);
    }
    }
    private int findPivot(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
        int mid = (left + right) / 2;

        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}
private int binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
}
