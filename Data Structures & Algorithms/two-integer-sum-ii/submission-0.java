class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            // if sum is equal, we have a match
            if (sum == target) {
                return new int[] {l+1, r+1};
            } else if (sum < target) {
                // if sum is less, increase left to look for larger numbers
                l++;
            } else {
                // if sum is more, decrease right to look for smaller numbers
                r--;
            }
        }

        return new int[] {0, 0};
    }
}
