class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        // 2 choices
        // 1. not select current index
        dfs(nums, i+1, curr);
        // 2. select current index
        curr.add(nums[i]);
        dfs(nums, i+1, curr);
        curr.remove(curr.size() - 1);
    }
}
