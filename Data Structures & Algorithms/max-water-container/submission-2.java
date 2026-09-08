class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        int i=0;
        int j=heights.length -1;

        while(i<j){
            int area = (j-i)*Math.min(heights[i], heights[j]);
            if(area > ans){
                ans = area;
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
