class Solution {
    public int maxLength(int[] ribbons, int k) {

        int n = ribbons.length;

        int maxL = ribbons[0];
        int minL = ribbons[0];

        for(int i=0; i<n; i++){
            maxL = Math.max(maxL, ribbons[i]);
            minL = Math.min(minL, ribbons[i]);
        }

        int l = 1;
        int r = maxL;

        int ans = 0;

        while(l<=r && l>=0 && r<=maxL){
            int mid = (r-l)/2 + l;

            if(isPossible(ribbons,k,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
        
    }

    private boolean isPossible(int[] ribbons, int k, int curr){
        int num = 0;

        for(int i=0; i<ribbons.length; i++){
            num = num + ribbons[i]/curr;
            if(num >=k){
                return true;
            }
        }

        return false;
    }
}