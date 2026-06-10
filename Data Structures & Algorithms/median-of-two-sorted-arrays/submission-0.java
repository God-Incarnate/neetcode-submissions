class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = totalLeft - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {

                int leftMax = Math.max(l1, l2);

                if (((m + n) & 1) == 1) {
                    return leftMax;
                }

                int rightMin = Math.min(r1, r2);
                return (leftMax + rightMin) / 2.0;
            }

            if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}