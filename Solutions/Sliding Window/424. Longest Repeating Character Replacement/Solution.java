import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        int wStart = 0, maxLength=0, maxRepeatCount = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int wEnd = 0; wEnd<s.length();wEnd++){
            char rightChar = s.charAt(wEnd);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar,0)+1);

            maxRepeatCount = Math.max(maxRepeatCount, frequencyMap.get(rightChar));

            if(wEnd-wStart+1-maxRepeatCount>k){
                frequencyMap.put(s.charAt(wStart), frequencyMap.get(s.charAt(wStart))-1);
                wStart++;
                
            }

            maxLength = Math.max(maxLength, wEnd-wStart+1);
        }
        return maxLength;
    }
}
