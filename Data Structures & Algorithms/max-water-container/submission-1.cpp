class Solution {
public:
    int maxArea(vector<int>& heights) {
        int i=0;
        int n = heights.size();
        int j = n-1;
        int maxArea = 0;

        vector<int> maxRight(n);
        vector<int> maxLeft(n);
        int maxR=0;
        int maxL=0;

        for(int k=0; k< n; k++){
            if(maxR < heights[n-k-1]){
                maxR=heights[n-k-1];
            }
            if(maxL< heights[k]){
                maxL = heights[k];
            }
            maxRight[n-k-1] = maxR;
            maxLeft[k] = maxL;
        }

        while(i < j){
            int area = (j-i) * min(maxRight[j], maxLeft[i]);
            if(area > maxArea){
                maxArea = area;
            }
            if(maxRight[j] < maxLeft[i]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
    }
};
