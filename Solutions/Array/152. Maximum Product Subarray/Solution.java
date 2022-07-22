class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1;
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            res = Math.max(res, num);
        }

        for (int num : nums) {
            if (num == 0) {
                curMax = 1;
                curMin = 1;
                continue;
            }
            int tmpCurMax = curMax * num;
            curMax = Math.max(Math.max(tmpCurMax, curMin * num), num);
            curMin = Math.min(Math.min(tmpCurMax, curMin * num), num);

            res = Math.max(res, curMax);
        }

        return res;
    }
}