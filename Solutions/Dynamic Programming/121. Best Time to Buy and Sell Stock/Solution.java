class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
        
    }
}