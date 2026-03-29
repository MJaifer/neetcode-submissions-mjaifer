class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<String, Integer> dp = new HashMap<>();
        return dfs(nums, target, n-1, dp);    
    }

    private int dfs(int[] nums, int target, int i, Map<String, Integer> dp) {
        if (i < 0 && target != 0) {
            return 0;
        }

        if (i < 0 && target == 0) {
            return 1;
        }

        String key = getKey(target, i);

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // two choices
        // 1. add current number
        int add = dfs(nums, target - nums[i], i-1, dp);

        // 2. substract current number
        int sub = dfs(nums, target + nums[i], i-1, dp);
        int sum = add + sub;
        dp.put(key, sum);

        return sum;
    }

    private String getKey(int target, int i) {
        return new StringBuilder().append(target).append('_').append(i).toString();
    }
}
