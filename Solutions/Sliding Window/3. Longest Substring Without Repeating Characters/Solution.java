import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, maxLength = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd<s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            if(frequencyMap.containsKey(rightChar)){
                windowStart = Math.max(windowStart, frequencyMap.get(rightChar)+1);
            }

            frequencyMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);


        }
        return maxLength;
    }
}