import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        //prefix sum to record the sum of plates on every position
        int[] sum = new int[n + 1];
        //using a list to record the index of every candle in the array
        List<Integer> list = new ArrayList<>();
        int m = queries.length;
        int[] res = new int[m];

        //record list and prefix sum
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                list.add(i);
            sum[i + 1] = sum[i] + (s.charAt(i) == '|' ? 0 : 1);
        }
        if(list.size()==0){
            return res;
        }

        //For every query, first using binary search to find the most left candle, 
        //Then the same method to find the most right candle
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = -1, d = -1;

            int l = 0;
            int r = list.size() - 1;

            // find upperbound of a
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= a) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (list.get(r) >= a)
                c = list.get(r);
            else
                continue;

            // find lowerboud of b
            l = 0;
            r = list.size() - 1;

            // find upperbound of a
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= b) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            if (list.get(r) <= b)
                d = list.get(r);
            else
                continue;
            
            if (c <= d)
                res[i] = (sum[d + 1] - sum[c]);

        }
        return res;

    }
}