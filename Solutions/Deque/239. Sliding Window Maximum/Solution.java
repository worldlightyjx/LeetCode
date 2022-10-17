import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (i >= k - 1) {
                while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                    queue.pollFirst();
                }
                ans[i - k + 1] = nums[queue.peekFirst()];

            }
        }
        return ans;

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            queue.add(new int[] { i, nums[i] });
            if (i >= k - 1) {
                while (queue.peek()[0] <= i - k) {
                    queue.poll();
                }
                ans[i - k + 1] = queue.peek()[1];
            }
        }
        return ans;

    }
}