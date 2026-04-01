class Solution {
    public int maxProfit(int[] prices) {
        // two pointer
        int l = 0, r = 0;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                // sell
                maxProfit = Math.max(maxProfit, prices[r]-prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
