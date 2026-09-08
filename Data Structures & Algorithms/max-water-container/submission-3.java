class Solution {
    public int maxArea(int[] heights) {

        int ans = 0;

        int i=0;
        int j = heights.length - 1;

        while(i<j){
            int currArea = Math.min(heights[i], heights[j]) * (j-i);

            if(ans < currArea){
                ans = currArea;
            }

            if(heights[i] < heights[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return ans;
        
    }
}
