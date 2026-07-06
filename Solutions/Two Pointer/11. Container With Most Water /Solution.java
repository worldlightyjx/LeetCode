class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            int tmpAns = height[l] < height[r] ? ((r - l) * height[l]) : ((r - l) * height[r]);
            ans = Math.max(ans, tmpAns);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return ans;
    }
}