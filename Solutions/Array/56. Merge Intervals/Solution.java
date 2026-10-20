class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.size() > 0 && interval[0] <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}