class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
            if ((ch < '0' || ch > '9') && ch != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                }
                sign = ch;
                num = 0;
            }

        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;

    }
}