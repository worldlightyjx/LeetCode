import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> hashset = new HashSet<>();
      for(int num:nums){
        if(hashset.contains(num)){
          return true;
        }
        hashset.add(num);
      }
      return false;


    }
}