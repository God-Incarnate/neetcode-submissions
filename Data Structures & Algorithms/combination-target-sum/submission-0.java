class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);                         // choose
            backtrack(i, nums, target - nums[i], curr, result); // reuse allowed
            curr.remove(curr.size() - 1);              // backtrack
        }
    }
}
