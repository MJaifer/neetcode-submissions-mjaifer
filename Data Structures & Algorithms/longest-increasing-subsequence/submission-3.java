class Solution {
    public int lengthOfLIS(int[] nums) {
        // binary search solution

        // store the lis in a list, which will always be sorted
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int lis = 1;
        for (int num: nums) {
            // insert to temp if current element is contributing to the current LIS sequence
            // ie., if current element is greater than the last element of temp

            if (num > temp.get(temp.size()-1)) {
                temp.add(num);
                lis++;
            } else {
                // find the lower bound of current element in temp list and insert it to that position
                // we are only interested in the length of lis
                int index = lowerbound(temp, num);
                temp.set(index, num);
            }
        }

        return lis;
    }

    private int lowerbound(List<Integer> arr, int target) {
        int low = 0, high = arr.size()-1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            // lower bound is the index of first number which is less than or equal to target
            // arr = [1,2,2,3] and target = 2 => lowerbound = 2

            if (target <= arr.get(mid)) {
                index = mid; // possible lower bound

                // try for better answer by eliminating the right
                high = mid - 1;

            } else {
                // eliminate the left
                low = mid + 1;
            }
        }

        return index;
    }
}
