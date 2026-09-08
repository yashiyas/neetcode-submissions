class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int ans = Integer.MIN_VALUE;

        ArrayDeque<Pair> aq = new ArrayDeque();

        for(int i=0; i<heights.length; i++){
            Pair p = new Pair();
            p.value = heights[i];
            p.index = i;

            if(aq.isEmpty()){
                aq.push(p);
            }
            else{
                while(!aq.isEmpty()){
                    Pair p1 = aq.peek();
                    if(p1.value > heights[i]){
                        int area = (i - p1.index)*p1.value;
                        if(ans < area){
                            ans = area;
                        }
                        p.index = p1.index;
                        aq.pop();
                    } else{
                        break;
                    }
                }
                aq.push(p);
            }
        }

        while(!aq.isEmpty()){
            Pair p = aq.pop();
            int area = (heights.length - p.index)*p.value;
            if(ans < area){
                ans = area;
            }
        }

        return ans;

    }

    class Pair {
        int value;
        int index;

        Pair(){

        }
    }
}
