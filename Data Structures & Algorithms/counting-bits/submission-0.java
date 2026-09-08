class Solution {
    public int[] countBits(int n) {

        int[] res = new int[n+1];
        
        res[0] = 0;
        int prev = 0;
        
        for(int i=1; i<=n; i++){
            if(isPowerOf2(i)){
                res[i] = 1;
                prev = i;
            }
            else{
                res[i] = res[prev] + res[i-prev];
            }
        }

        return res;
        
    }

    private boolean isPowerOf2(int x){
        return (x & (x-1)) == 0;
    }
}
