class Solution {
    public int findNthDigit(int n) {
        long cnt = 9, s = 1, k = 1;
        while (n > cnt * k) {
            n -= cnt * k;
            s *= 10;
            cnt *= 10;
            k++;
        }

        long res = s + (n + k - 1) / k - 1;
        int idx = (int)(n % k == 0 ? k : n % k);
        return Character.getNumericValue(Long.toString(res).charAt(idx-1));
    
    }
}