class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] lHeight = new int[n];
        lHeight[0] = height[0];
        int prev = height[0];

        for(int i=1; i<n; i++){
            if(height[i] > prev){
                prev = height[i];
            }

            lHeight[i] = prev;
        }

        int[] rHeight = new int[n];
        rHeight[n-1] = height[n-1];
        prev = height[n-1];

        for(int i=n-2; i>=0; i--){
            if(height[i] > prev){
                prev = height[i];
            }

            rHeight[i] = prev;
        }

        int ans = 0;

        for(int i=1; i<n-1; i++){
            int currH = (Math.min(lHeight[i-1], rHeight[i+1]) - height[i]);
            if(currH < 0){
                currH = 0;
            }
            ans = ans + currH;
        }

        return ans;
        
    }
}
