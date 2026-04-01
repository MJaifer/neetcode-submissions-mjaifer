class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];

        for (int price: prices) {
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(min, price);
        }

        return maxProfit;
    }
}
