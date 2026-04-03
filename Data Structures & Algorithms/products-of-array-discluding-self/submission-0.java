class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] rightP = new int[n];
        rightP[n-1] = 1;

        for (int i = n-2; i >= 0; i--) {
            // [  1  ,  2,  4, 6]
            // [2*4*6, 4*6, 6, 1]
            rightP[i] = rightP[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        int prevProd = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prevProd * rightP[i];
            prevProd *= nums[i];
        }

        return ans;
    }
}  
