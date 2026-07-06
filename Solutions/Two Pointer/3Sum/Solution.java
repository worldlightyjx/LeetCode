class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int firstNum = nums[i];
            if (i > 0 && firstNum == nums[i - 1]) continue;
            if (firstNum + nums[i + 1] + nums[i + 2] > 0) break;
            if (firstNum + nums[n - 1] + nums[n - 2] < 0) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = firstNum + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    ans.add(List.of(firstNum, nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }

        }
        return ans;
    }
}