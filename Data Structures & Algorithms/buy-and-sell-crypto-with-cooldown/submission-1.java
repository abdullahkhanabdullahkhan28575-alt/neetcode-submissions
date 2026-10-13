public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp1_buy = 0, dp1_sell = 0;
        int dp2_buy = 0;

        for (int i = n - 1; i >= 0; i--) {
            int dp_buy = Math.max(dp1_sell - prices[i], dp1_buy);
            int dp_sell = Math.max(dp2_buy + prices[i], dp1_sell);
            dp2_buy = dp1_buy;
            dp1_buy = dp_buy;
            dp1_sell = dp_sell;
        }

        return dp1_buy;
    }
}