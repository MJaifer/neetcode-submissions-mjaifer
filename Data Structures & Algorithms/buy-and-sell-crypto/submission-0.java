class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (min < curr) {
                // sell
                int curProfit = curr - min;
                max = Math.max(max, curProfit);
            }  else {
                // update min
                min = curr;
            }
        }

        return max;
    }
}
