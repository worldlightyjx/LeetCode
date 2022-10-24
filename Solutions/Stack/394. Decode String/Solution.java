class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<String> res = new Stack<>();

        int idx = 0;
        int n = s.length();
        res.push("");
        while (idx < n) {
            char ch = s.charAt(idx);
            if (ch >= '0' && ch <= '9') {
                int start = idx;
                while (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '9')
                    idx++;
                numSt.push(Integer.parseInt(s.substring(start, idx + 1)));
            } else if (ch == '[') {
                res.push("");
            } else if (ch == ']') {
                String str = res.pop();
                int cnt = numSt.pop();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    sb.append(str);
                }
                res.push(res.pop() + sb.toString());
            } else {
                res.push(res.pop() + ch);
            }
            idx += 1;
        }
        return res.pop();
    }
}