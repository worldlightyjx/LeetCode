class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int[][] dp = new int[n][2];
        // first day has share， means first day has bought a share, the value should be -prices[0]
        //dp[0][1] = -prices[0];
        int noShare = 0;
        int hasShare = -prices[0];
        for(int i=1; i<n; i++){
            //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            noShare = Math.max(noShare, hasShare+prices[i]-fee);
            //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            hasShare = Math.max(hasShare, noShare-prices[i]);
        }
        return noShare;
        
    }
}