class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int index, int[] nums, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length || target < 0) return;

        // Include
        curr.add(nums[index]);
        dfs(index, nums, target - nums[index], curr, result);

        curr.remove(curr.size() - 1);

        // Exclude
        dfs(index + 1, nums, target, curr, result);
    }
}
