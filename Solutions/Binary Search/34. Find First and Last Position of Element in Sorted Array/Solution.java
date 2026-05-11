class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        }

        int end = lowerBound(nums, target + 1) - 1;
        return new int[] { start, end };
    }

    private int lowerBound(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }
}