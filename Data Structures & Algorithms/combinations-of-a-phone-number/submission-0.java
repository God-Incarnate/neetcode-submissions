class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, new StringBuilder(), result, map);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder curr,
                           List<String> result, String[] map) {

        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            curr.append(c);
            backtrack(index + 1, digits, curr, result, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    
    }
}
