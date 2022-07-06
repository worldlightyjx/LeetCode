class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart =0, maxOnes = 0, maxLength = 0;
        for(int windowEnd = 0; windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd]==1){
                maxOnes++;
            }

            if(windowEnd-windowStart+1-maxOnes>k){
                if(nums[windowStart]==1){
                    maxOnes--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}