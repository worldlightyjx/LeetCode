class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[r] == target) {
            res[0] = r;
        } else {
            res[0] = -1;
        }

        l = 0;
        r = nums.length - 1;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[r] == target) {
            res[1] = r;
        } else {
            res[1] = -1;
        }

        return res;

    }
}