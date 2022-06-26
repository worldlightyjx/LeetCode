import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int windowStart = 0;

        Map<Integer,Integer> fruitTypeToNumMap = new HashMap<>();

        int maxLength = Integer.MIN_VALUE;

        for(int windowEnd=0; windowEnd<n;windowEnd++){
            fruitTypeToNumMap.put(fruits[windowEnd],fruitTypeToNumMap.getOrDefault(fruits[windowEnd],0)+1);

            while(fruitTypeToNumMap.size()>2){
                fruitTypeToNumMap.put(fruits[windowStart], fruitTypeToNumMap.get(fruits[windowStart])-1);
                if(fruitTypeToNumMap.get(fruits[windowStart])==0){
                    fruitTypeToNumMap.remove(fruits[windowStart]);
                }

            windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }
}