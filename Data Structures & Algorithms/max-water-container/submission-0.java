class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
    int right = heights.length - 1;
    int maxWater = 0;

    while (left < right) {
        int height = Math.min(heights[left], heights[right]);
        int width = right - left;
        maxWater = Math.max(maxWater, height * width);

        // move the smaller height
        if (heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxWater;
    }
}
