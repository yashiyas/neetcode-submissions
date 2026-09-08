class Solution {
    public int largestRectangleArea(int[] heights) {

        ArrayDeque<Pair> aq = new ArrayDeque();

        int n = heights.length;

        int ans = 0;

        for(int i=0; i<n; i++){
            Pair curr = new Pair(heights[i], i);
            if(aq.isEmpty()){
                aq.push(curr); 
            }else{
                while(!aq.isEmpty() && aq.peek().height > heights[i]){
                    Pair top = aq.pop();
                    int index = top.pos;
                    int currArea = top.height * (i-index);
                    ans = Math.max(currArea, ans);
                    curr.pos = index;
                }
                aq.push(curr);
            }
        }

        while(!aq.isEmpty()){
            Pair top = aq.pop();
            int currArea = top.height * (n-top.pos);
            ans = Math.max(ans, currArea);
        }

        return ans;
        
    }

    class Pair{
        int height;
        int pos;

        Pair(int h, int p){
            this.height = h;
            this.pos = p;
        }
    }
}
