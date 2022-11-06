class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int remain = 0;
            int tmpSum = 0;
            while (n != 0) {
                remain = n % 10;
                tmpSum += remain * remain;
                n /= 10;
            }

            if (tmpSum == 1) {
                return true;
            } else {
                n = tmpSum;
            }
        }
        return false;
    }
}