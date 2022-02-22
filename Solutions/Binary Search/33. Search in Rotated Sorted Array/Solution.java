class Solution {
    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] >= nums[0])
                l = mid;
            else
                r = mid - 1;
        }

        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = nums.length - 1;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return nums[r] == target ? r : -1;
    }
}
