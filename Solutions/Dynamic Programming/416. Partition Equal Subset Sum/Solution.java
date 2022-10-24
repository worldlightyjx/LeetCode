class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int j = 0; j < target + 1; j++) {
            dp[0][j] = j >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < target + 1; j++) {
                int notSelect = dp[i - 1][j];
                int select = j >= num ? dp[i - 1][j - num] + num : 0;
                dp[i][j] = Math.max(select, notSelect);
            }
        }
        return dp[n - 1][target] == target;

    }
}