public class Solution1 {
    int n = nums.length;
        if (n < k) {
            k = k % n;
        }

        int[] ans = new int[n];
        int idx = 0;
        for (int i = n - k; i < n; i++) {
            ans[idx++] = nums[i];
        }
        for (int i = 0; i < n - k; i++) {
            ans[idx++] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
}
