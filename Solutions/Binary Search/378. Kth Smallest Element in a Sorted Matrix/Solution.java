class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], r = matrix[matrix[0].length-1][matrix[0].length-1];
        while(l<r){
            int mid = l + (r-l)/2;
            int cnt = 0;
            int i = matrix[0].length-1;
            for(int j = 0;j<matrix[0].length;j++){
                while(i>=0&&matrix[j][i]>mid) i--;
                cnt+=i+1;
            }
            if(cnt>=k){
                r=mid;
            }else{
                l =  mid+1;
            }
        }
        return r;
        
    }
}