class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int num = nums[i];
            if(hash.containsKey(target-num)){
                return new int[]{i,hash.get(target-num)};
            }
            hash.put(num,i);
        }
        return new int[]{-1,-1};
    }
}