class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int total = 0;
        int maxW = 0;

        for(int i: weights){
            total+=i;
            maxW = Math.max(maxW, i);
        }

        int l = maxW;
        int r = total;

        int ans = total;

        while(l<=r){

            int mid = (r-l)/2 + l;

            if(canShip(mid, weights, days)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }

        }

        return ans;
        
    }

    private boolean canShip(int capacity, int[] weights, int days){
        int currD = 0;
        int i = 0;
        int currW = 0;

        while(i<weights.length && currD <days){
            while(i<weights.length && currW+weights[i] <= capacity){
                currW=currW+weights[i];
                i++;
            }
            currD++;
            currW=0;
        }

        return(currD <= days && i==weights.length);
    }
}