class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        int idx = 0;
        while (nonZeroIdx < nums.length) {
            if (nums[nonZeroIdx] != 0) {
                nums[idx] = nums[nonZeroIdx];
                nonZeroIdx++;
                idx++;
            } else {
                nonZeroIdx++;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }

    }
}