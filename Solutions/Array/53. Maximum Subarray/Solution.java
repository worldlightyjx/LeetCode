class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;

        int curSum = 0;
        int maxSum = nums[0];

        for(int num : nums){
            if(curSum<0){
                curSum = 0;
            }
            curSum+=num;

            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}