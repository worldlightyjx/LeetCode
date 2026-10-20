class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);

            int left = i - k + 1;
            if (q.getFirst() < left) {
                q.removeFirst();
            }
            if (left >= 0) {
                ans[left] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}