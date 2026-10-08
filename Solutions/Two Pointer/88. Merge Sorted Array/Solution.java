class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[n + m];
        int cur1 = 0, cur2 = 0;
        int idx = 0;
        while (cur1 < m || cur2 < n) {
            if (cur1 == m) {
                ans[idx++] = nums2[cur2];
                cur2++;
            } else if (cur2 == n) {
                ans[idx++] = nums1[cur1];
                cur1++;

            } else if (nums1[cur1] < nums2[cur2]) {
                ans[idx++] = nums1[cur1];
                cur1++;
            } else {
                ans[idx++] = nums2[cur2];
                cur2++;
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
}