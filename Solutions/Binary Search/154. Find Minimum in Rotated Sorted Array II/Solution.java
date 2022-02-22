class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int n = nums.length - 1;
        //remove duplicate part so that the array can be splited into two parts
        while (n >= 0 && nums[0] == nums[n]) {
            n--;
        }
        if (n < 0)
            return nums[0];

        //nevigate the reverse point
        int l = 0, r = n;
        while (l < r) {
            int mid = l+r + 1 >>1;
            if(nums[mid]>=nums[0]){
                l = mid;
            }else{
                r = mid -1;
            }
        }

        return r + 1<= n ? nums[r+1]:nums[0];

    }
}