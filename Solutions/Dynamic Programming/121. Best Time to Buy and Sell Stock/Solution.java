class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int ans = 0;
        for (int num : prices) {
            ans = Math.max(ans, num - minPrice);
            minPrice = Math.min(minPrice, num);
        }
        return ans;

    }
}