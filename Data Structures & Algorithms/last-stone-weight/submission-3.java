class Solution {
    public int lastStoneWeight(int[] stones) {
     PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Collections.reverseOrder());
    
    for (int stone : stones) {
        maxHeap.offer(stone);
    }
    
    while (maxHeap.size() > 1) {
        int y = maxHeap.poll(); // largest
        int x = maxHeap.poll(); // second largest
        
        if (y != x) {
            maxHeap.offer(y - x);
        }
    }
    
    return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
