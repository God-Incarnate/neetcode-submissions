class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // sort by end time
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // overlap
            if (intervals[i][0] < prevEnd) {
                removals++;
            }
            else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}