class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i == nums.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        // skip
        dfs(nums, i+1, target, curr);

        // select
        curr.add(nums[i]);
        dfs(nums, i, target-nums[i], curr);
        curr.remove(curr.size() - 1);
    }
}
