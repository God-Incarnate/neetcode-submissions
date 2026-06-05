class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<Long, List<String>> map = new HashMap<>();
    
    int[] primes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
        31, 37, 41, 43, 47, 53, 59, 61, 
        67, 71, 73, 79, 83, 89, 97, 101
    };
    
    for (String s : strs) {
        long key = 1;
        for (char c : s.toCharArray()) {
            key *= primes[c - 'a'];
        }
        
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(s);
    }
    
    return new ArrayList<>(map.values());
    }
}
