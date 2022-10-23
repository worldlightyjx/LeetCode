class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && temp[i] > temp[st.peek()]) {
                int index = st.pop();
                ans[index] = i - index;
            }

            st.push(i);

        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        for (int i = 0; i < n; i++) {
            int curTemp = temp[i];
            for (int j = i + 1; j < n; j++) {
                if (temp[j] > curTemp) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}