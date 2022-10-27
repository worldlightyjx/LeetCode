class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int cnt = 0;
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                cnt++;
            }
            for(int j=2;j*i<n;j++){
                notPrime[i*j]=true;
            }
        }
        return cnt;
        
    }
}