class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty()
                    && heights[stack.peek()] > currHeight) {

                int height = heights[stack.pop()];

                int leftBoundary =
                        stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftBoundary - 1;

                maxArea = Math.max(maxArea,
                                   height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}