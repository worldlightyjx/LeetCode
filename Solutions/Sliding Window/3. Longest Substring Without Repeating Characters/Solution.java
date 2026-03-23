import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int[] cnt = new int[128];
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right);
            cnt[idx]++;

            while (cnt[idx] > 1) {
                cnt[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);

        }
        return res;

    }
}
