class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int cur, List<String> curAns, List<List<String>> res) {
        if (cur == s.length()) {
            res.add(new ArrayList<>(curAns));
            return;
        }

        for (int i = cur; i < s.length(); i++) {
            if (isPalindrome(s, cur, i)) {
                curAns.add(s.substring(cur, i + 1));
                dfs(s, i + 1, curAns, res);
                curAns.remove(curAns.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}                                                               