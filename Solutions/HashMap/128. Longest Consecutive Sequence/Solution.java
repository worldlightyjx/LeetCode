class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int ans = 0;
        for (int num : st) {

            if (st.contains(num - 1)) {
                continue;
            }

            int y = num + 1;
            while (st.contains(y)) {
                y++;
            }
            //from num to y-1 total has y-1-num+1= y-num
            ans = Math.max(ans, y - num);
        }
        return ans;

    }
}