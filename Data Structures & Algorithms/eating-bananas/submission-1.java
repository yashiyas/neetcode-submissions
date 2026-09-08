class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int r = 1;
        int l = Integer.MIN_VALUE;

        for(int i:piles){
            if(l < i){
                l = i;
            }
        }
        int ans = l;

        while(r <=l ){
            int mid = r + (l-r)/2;

            if(canEat(mid, piles, h)){
                ans=mid;
                l = mid-1;
            }
            else{
                r = mid+1;
            }
        }

        return ans;


        
    }

    private boolean canEat(int speed, int[] piles, int h){
        int t=0;

        for(int i=0; i<piles.length; i++){
            int curr = piles[i];
            t= t+ (curr/speed);
            if(curr%speed != 0){
                t++;
            }
            if(t>h){
                return false;
            }
        }
        return true;
    }
}
