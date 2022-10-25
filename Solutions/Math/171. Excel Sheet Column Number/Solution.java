class Solution {
    public int titleToNumber(String columnTitle) {

        int n = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = columnTitle.charAt(n - i - 1) - 'A' + 1;
            int frac = (int) Math.pow(26, i);
            ans += num * frac;
        }
        return ans;
    }
}