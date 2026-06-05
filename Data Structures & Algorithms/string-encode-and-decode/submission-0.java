class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            
            // find '#'
            while (s.charAt(j) != '#') {
                j++;
            }
            
            int length = Integer.parseInt(s.substring(i, j));
            j++; // skip '#'
            
            String word = s.substring(j, j + length);
            result.add(word);
            
            i = j + length;
        }
        
        return result;
    }
}
