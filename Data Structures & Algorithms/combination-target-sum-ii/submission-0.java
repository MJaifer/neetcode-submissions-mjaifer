class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> current) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (i == nums.length || target < 0) {
            return;
        }

        // select current element
        current.add(nums[i]);
        dfs(nums, i+1, target-nums[i], current);
        current.remove(current.size()-1);

        // skip duplicates in not-select branch
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs(nums, i+1, target, current);
    }
}
