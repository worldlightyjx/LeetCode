class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int left = 0;
        int len = s.length();
        int res = 0;
        int maxHistoryFreqCount = 0;
        for (int right = 0; right < len; right++) {
            int charIdx = s.charAt(right) - 'A';
            freqMap[charIdx]++;
            maxHistoryFreqCount = Math.max(maxHistoryFreqCount, freqMap[charIdx]);

            if (right - left + 1 > maxHistoryFreqCount + k) {
                freqMap[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(right - left + 1, res);

        }
        return res;
    };
}