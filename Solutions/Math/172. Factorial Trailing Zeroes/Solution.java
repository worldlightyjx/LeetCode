class Solution {
    public int trailingZeroes1(int n) {
        int cnt = 0;

        while (n > 0) {
            n /= 5;
            cnt += n;
        }

        return cnt;

    }

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);

    }
}