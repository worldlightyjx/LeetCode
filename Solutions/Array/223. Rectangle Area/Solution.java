class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int coveredLX = Math.max(ax1, bx1);
        int coveredRX = Math.max(Math.min(ax2, bx2), coveredLX);

        int coveredDY = Math.max(by1, ay1);
        int coveredUY = Math.max(Math.min(by2, ay2), coveredDY);

        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)
                - (coveredRX - coveredLX) * (coveredUY - coveredDY);
    }
}