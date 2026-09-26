class Solution {
    public int numWays(int n, int k) {

        if(n==0){
            return 0;
        }

        if(n==1){
            return k;
        }

        if(n==2){
            return k+k*(k-1);
        }

        int[] total = new int[n+1];
        total[1] = k;
        total[2] = k + k * (k-1);

        int diffPrev = k * (k-1);

        for(int i=3; i<=n; i++){
            int temp = total[i-1]*(k-1);
            total[i] = diffPrev + temp;
            diffPrev = temp;
        }

        return total[n];
        
    }
}
