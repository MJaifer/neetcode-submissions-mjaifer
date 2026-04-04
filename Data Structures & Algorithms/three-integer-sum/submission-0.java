class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        
        // ni + nj + nk = 0
        // nj + nk = - ni
        // 2 sum target = -ni
        for (int i = 0; i < len-1; i++) {
            // if ni is > 0 => the remaining two numbers will also be > 0 as the array is sorted
            if (nums[i] > 0) break; // no possible solutions after this

            // skip duplicate ni
            if (i > 0 && nums[i] == nums[i-1]) continue; // this result was already calculated in the previous iteration

            int target = - nums[i];

            int left = i+1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(new Integer[] {nums[i], nums[left], nums[right]}));
                    left++;
                    right--;
                    // skip duplicates
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
