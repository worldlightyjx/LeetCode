class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));

            if (max == i) {
                ans.add(max - prev);
                prev = max;
            }
        }
        return ans;

    }
}