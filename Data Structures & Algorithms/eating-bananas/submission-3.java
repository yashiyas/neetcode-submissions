class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxSpeed = piles[0];

        for(int i: piles){
            maxSpeed = Math.max(i,maxSpeed);
        }

        if(h == piles.length){
            return maxSpeed;
        }

        int ans = maxSpeed;

        int l = 1;
        int r = maxSpeed;

        while(l<=r){
            int mid = (r-l)/2 + l;

            int hours = getHours(mid,piles);

            if(hours > h){
                l = mid+1;
            }

            else{
                ans = mid;
                r = mid-1;
            }

        }

        return ans;
        
    }

    private int getHours(int speed, int[] piles){
        int h = 0;

        for(int i=0; i<piles.length; i++){
            if(piles[i] <= speed){
                h++;
            }else{
                h = h+(piles[i]/speed);
                if(piles[i] % speed != 0){
                    h++;
                }
            }
        }

        return h;
    }
}
