import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = Math.max(houses[houses.length-1], heaters[heaters.length-1]);
        while(l<r){
            int mid = l+(r-l)/2;
            if(check(mid,houses,heaters)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return r;
        
    }

    private boolean check(int mid, int[] houses, int[] heaters){
        //for each house, find first heaters that covers it
        for(int i = 0, j = 0; i<houses.length;i++){
            while(j<heaters.length && Math.abs(houses[i]-heaters[j])>mid){
                j++;

            }
            if(j>=heaters.length){
                return false;
            }
        }
        return true;
    }
}