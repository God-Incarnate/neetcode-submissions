class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {

        left = new PriorityQueue<>(
                (a, b) -> b - a); // max heap

        right = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {

        left.offer(num);

        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}
