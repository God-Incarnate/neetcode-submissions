class Solution {
    public int[][] merge(int[][] intervals) {

        // sort by start time
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // overlap
            if (next[0] <= current[1]) {

                current[1] =
                    Math.max(current[1], next[1]);
            }
            else {
                result.add(current);
                current = next;
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}