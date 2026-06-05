class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // 🔥 Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break; // optimization

            curr.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], curr, result); // move forward (no reuse)
            curr.remove(curr.size() - 1);
        }
    
    }
}
