class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quick select
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length-1, targetIndex);
    }

    private int quickSelect(int[] nums, int l, int r, int targetIndex) {
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                // if current number is less than or equal to pivot
                // swap ith and pth numbers and increment p
                swap(nums, i, p);
                p++;
            }
        }

        // p is the correct index of pivot in sorted array
        // swap pth number and pivot number (rth num)
        swap(nums, p, r);
        
        // if p is on the left of target index, eliminate right half
        if (p > targetIndex) {
            return quickSelect(nums, l, p-1, targetIndex);
        } else if (p < targetIndex){
            // if p is on the right of target index, eliminate left half
            return quickSelect(nums, p+1, r, targetIndex);
        } else {
            // if p is equal to target index, nums[p] is the answer
            return nums[p];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
