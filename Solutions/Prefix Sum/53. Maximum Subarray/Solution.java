class Solution {
    public int maxSubArray(int[] nums) {
      int minPreSum = 0;
      int ans = Integer.MIN_VALUE;
      int preSum = 0;
      for(int num:nums){
        preSum+=num;
        ans = Math.max(ans,preSum-minPreSum);
        minPreSum = Math.min(preSum,minPreSum);
      }
      return ans;

    }
}