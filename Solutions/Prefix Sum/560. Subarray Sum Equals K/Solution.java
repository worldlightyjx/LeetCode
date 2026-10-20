class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int sum : prefixSum) {
            ans += cnt.getOrDefault(sum - k, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}