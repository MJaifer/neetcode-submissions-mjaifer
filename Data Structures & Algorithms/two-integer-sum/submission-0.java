class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int requiredNum = target - nums[i];
            if (map.containsKey(requiredNum)) {
                int i2 = map.get(requiredNum);
                return i < i2? new int[]{i, i2}: new int[]{i2, i}; 
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
