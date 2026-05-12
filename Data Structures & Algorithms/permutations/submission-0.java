class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> selected = new HashSet<>();
        res = new ArrayList<>();
        dfs(nums, selected, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, Set<Integer> selected, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!selected.contains(i)) {
                curr.add(nums[i]);
                selected.add(i);
                dfs(nums, selected, curr);
                selected.remove(i);
                curr.remove(curr.size()-1);
            }
        }

    }
}
