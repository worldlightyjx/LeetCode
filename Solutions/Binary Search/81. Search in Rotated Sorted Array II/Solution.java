class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length-1;
        // eliminate duplicate part so that the array can be clearly separated into two
        // parts
        while (n >= 0 && nums[n] == nums[0])
            n--;
        if (n < 0)
            return nums[0]==target;

        // find the reverse point using binary search
        int l = 0;
        int r = (n==nums.length)?nums.length-1:n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        

        // decide which part to find target
        if (target>=nums[0]) {
            l=0;
            
        } else {
            l++;
            r = n;
        }

        // find target using binary search
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[r] == target ? true : false;
    }
}