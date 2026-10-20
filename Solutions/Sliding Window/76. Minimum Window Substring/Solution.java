class Solution {
    public String minWindow(String s, String t) {
        int[] cnts = new int[128];
        int[] cntt = new int[128];
        for (char c : t.toCharArray()) {
            cntt[c]++;
        }

        char[] sarr = s.toCharArray();
        int ansLeft = -1;
        int ansRight = s.length();

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            cnts[sarr[r]]++;
            while (isCovered(cnts, cntt)) {
                if (r - l < ansRight - ansLeft) {
                    ansLeft = l;
                    ansRight = r;
                }
                cnts[sarr[l]]--;
                l++;
            }
        }

        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    private boolean isCovered(int[] cnts, int[] cntt) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cnts[i] < cntt[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cnts[i] < cntt[i]) {
                return false;
            }
        }
        return true;

    }
}