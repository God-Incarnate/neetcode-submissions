/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // sort by meeting start time
        Collections.sort(intervals,
                (a, b) -> Integer.compare(a.start, b.start));

        // min heap stores end times
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        // first meeting
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            Interval current = intervals.get(i);

            // if earliest meeting room becomes free
            if (current.start >= minHeap.peek()) {
                minHeap.poll();
            }

            // allocate/reuse room
            minHeap.offer(current.end);
        }

        return minHeap.size();
    }
}
