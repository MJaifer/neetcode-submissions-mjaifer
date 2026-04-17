class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lA = nums1.length, lB = nums2.length;
        if (lA > lB) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = lA + lB;
        boolean isEven = ((total & 1) == 0);

        // no of elements required to form the left part of median => total / 2
        int nLeft = total / 2;

        int left = 0, right = lA;
        while (left <= right) {
            int midA = left + (right - left) / 2;
            
            // nA = midA
            // nB = nLeft - nA

            int midB = nLeft - midA;

            int aLeft = midA > 0? nums1[midA-1]: Integer.MIN_VALUE;
            int aRight = midA< lA? nums1[midA]: Integer.MAX_VALUE;
            int bLeft = midB > 0? nums2[midB-1]: Integer.MIN_VALUE;
            int bRight = midB < lB? nums2[midB]: Integer.MAX_VALUE;

            // if current partition is valid
            if (aLeft <= bRight && bLeft <= aRight) {
                if (isEven) {
                    return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                } else {
                    return (double) Math.min(aRight, bRight);
                }
            } else if (aLeft > bRight) {
                // we took more elements from A => try to reduce aLeft by going left
                right = midA - 1;
            } else {
                // we took more elements from B => try to increase aRight by going right
                left = midA + 1;
            }
        }

        return 0;
    }
}
