import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;

        for (int t = 1; t <= 26; t++) {
            Map<Character, Integer> charToCntMap = new HashMap<>();
            for (int i = 0, j = 0, diffrentCharNums = 0, satisfiedCharNums = 0; i < s.length(); i++) {
                char addChar = s.charAt(i);
                if (!charToCntMap.containsKey(addChar) || charToCntMap.get(addChar) == 0) {
                    diffrentCharNums++;
                    charToCntMap.put(addChar, 1);
                } else {
                    charToCntMap.put(addChar, charToCntMap.get(addChar) + 1);
                }
                if (charToCntMap.get(addChar) == k) {
                    satisfiedCharNums++;
                }
                while (diffrentCharNums > t) {
                    char delChar = s.charAt(j++);
                    if (charToCntMap.get(delChar) == k) {
                        satisfiedCharNums--;
                    }
                    if (charToCntMap.containsKey(delChar)) {
                        int cnt = charToCntMap.get(delChar) - 1;
                        charToCntMap.put(delChar, cnt);
                        if (cnt == 0) {
                            diffrentCharNums--;
                        }
                    }
                }
                if (satisfiedCharNums == diffrentCharNums) {
                    res = Math.max(res, i - j + 1);
                }

            }
        }
        return res;

    }

}