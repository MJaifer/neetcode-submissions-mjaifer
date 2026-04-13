class Solution {
    public int findMin(int[] nums) {
        // edge cases
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int min = Integer.MAX_VALUE;
        int left = 0, right = len-1;

        while (left <= right) {
            // we are in a sorted portion of the array
            // left is the min, stop the search
            if (nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                // nums[left] is a potential answer
                min = Math.min(min, nums[left]);
                // look for better answer by eliminating the entire half
                left = mid + 1;
            } else {
                // mid is smaller than left => mid is a potential answer
                min = Math.min(min, nums[mid]);
                // look for better answer by eliminating this half
                right = mid - 1;
            }
        }

        return min;

    }
}
