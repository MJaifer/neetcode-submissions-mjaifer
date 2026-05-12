class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // select
        curr.add(nums[i]);
        backtrack(nums, i+1, curr);
        curr.remove(curr.size()-1);

        // not select => skip the duplicates
        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }

        backtrack(nums, i+1, curr);
    }
}
