class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        String sign = ((numerator < 0) ^ (denominator < 0)) ? "-" : "";

        StringBuilder res = new StringBuilder();
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(sign);

        res.append(num / den);
        num %= den;

        if (num == 0) {
            return res.toString();
        }

        res.append(".");

        Map<Long, Integer> map = new HashMap<>();

        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.get(num) != null) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }

        return res.toString();
    }
}