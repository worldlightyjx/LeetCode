
class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (citations.length - mid <= citations[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return citations.length - l <= citations[l] ? citations.length - l : 0;
    }
}