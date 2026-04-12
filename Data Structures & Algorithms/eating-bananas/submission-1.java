class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        int low = 1, high = max;
        int minRate = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)) {
                minRate = mid;
                // try for lower mid
                high = mid - 1;
            } else {
                // try for higher mid
                low = mid + 1;
            }
        }

        return minRate;
    }

    private boolean canEat(int[] piles, int h, int rate) {
        int time = 0;
        for (int pile: piles) {
            time += (int) Math.ceil((double) pile/rate);
        }

        return (time <= h);
    }
}
