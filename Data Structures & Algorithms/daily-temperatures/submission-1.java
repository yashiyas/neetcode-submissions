class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        ArrayDeque<int[]> st = new ArrayDeque();
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            if(st.isEmpty()){
                st.push(new int[]{temperatures[i], i});
            }
            else{
                while(!st.isEmpty() && temperatures[i] > st.peek()[0]){
                    int[] top = st.pop();

                    ans[top[1]] = i-top[1];

                }

                st.push(new int[]{temperatures[i], i});
            }

        }

        return ans;
        
    }
}
