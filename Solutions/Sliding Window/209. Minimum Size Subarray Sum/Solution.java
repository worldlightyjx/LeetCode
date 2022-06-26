class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int windowStart = 0;

        int minSubArraryLength = Integer.MAX_VALUE;
        int sum = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            sum += nums[windowEnd];
            while (sum >= target) {
                minSubArraryLength = Math.min(minSubArraryLength, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }

        return minSubArraryLength == Integer.MAX_VALUE ? 0 : minSubArraryLength;

    }
}