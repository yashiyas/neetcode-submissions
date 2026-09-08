class Solution {
    public int largestRectangleArea(int[] heights) {

        ArrayDeque<Pair> aq = new ArrayDeque();

        int n = heights.length;

        int ans = 0;

        aq.push(new Pair(heights[0], 0));

        for(int i=1; i<heights.length; i++){
            Pair top = aq.peek();
            Pair curr = new Pair(heights[i], i);
            if(heights[i] >= top.height){
                aq.push(curr);
            }
            else{
                while(!aq.isEmpty() && aq.peek().height > heights[i]){
                    Pair popped = aq.pop();
                    int currArea = popped.height * (i-popped.index);
                    ans = Math.max(ans,currArea);
                    curr.index = popped.index;
                }

                aq.push(curr);
                
            }
        }

        while(!aq.isEmpty()){
            Pair top = aq.pop();
            int currArea = top.height * (n-top.index);
            ans = Math.max(ans,currArea);
        }

        return ans;
        
    }

    class Pair{
        int height;
        int index;

        Pair(int h, int i){
            this.height = h;
            this.index = i;
        }
    }
}
