class Solution {
    public int arrangeCoins(int n) {

        
        long l = 0;
        long r = n;

        long ans = 0;

        while(l<=r){
            long mid = (r-l)/2 + l;

            long req = (mid*(mid+1))/2;

            if(req > n){
                r = mid-1;
            }else{
                ans = mid;
                l = mid+1;
            }
        }

        return (int)ans;

      
    }
}