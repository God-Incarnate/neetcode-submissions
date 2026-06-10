class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int idx = 0;

        for (int i = 0; i < n; i++) {

            maxHeap.offer(new int[]{nums[i], i});

            // Remove elements outside current window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            if (i >= k - 1) {
                result[idx++] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}