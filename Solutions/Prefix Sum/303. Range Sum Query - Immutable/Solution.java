public class Solution {
    private final int[] s;

    public Solution(int[] nums) {
        s = new int[nums.length + 1];
        s[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
    
}
