class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    List<Integer>[] buckets = new List[nums.length + 1];
    
    for (int key : freq.keySet()) {
        int f = freq.get(key);
        
        if (buckets[f] == null) {
            buckets[f] = new ArrayList<>();
        }
        buckets[f].add(key);
    }
    
    int[] result = new int[k];
    int index = 0;
    
    for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
        if (buckets[i] != null) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) break;
            }
        }
    }
    
    return result;
    }
}
