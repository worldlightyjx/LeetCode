class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<Character, List<Integer>> stat = new HashMap<>();

        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            stat.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(j - i);
        }
        int ans = -1;

        for (List<Integer> vec : stat.values()) {
            int cnt = 0;
            int l = 0, r = n - 2;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                for (int x : vec) {
                    if (x >= mid) {
                        cnt += x - mid + 1;
                    }
                }
                if (cnt >= 3) {
                    ans = Math.max(ans, mid);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return ans;
    }
}