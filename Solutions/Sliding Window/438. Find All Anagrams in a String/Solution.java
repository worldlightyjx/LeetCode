class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int k = p.length();
        int[] cntp = new int[26];
        for (int i = 0; i < k; i++) {
            cntp[p.charAt(i) - 'a']++;
        }
        int l = 0;
        int[] cnts = new int[26];
        for (int r = 0; r < n; r++) {
            cnts[s.charAt(r) - 'a']++;

            int len = r - k + 1;
            if (len < 0) {
                continue;
            }

            if (Arrays.equals(cntp, cnts)) {
                ans.add(l);
            }
            cnts[s.charAt(l++) - 'a']--;
        }

        return ans;
    }
}