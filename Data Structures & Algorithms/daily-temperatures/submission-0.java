class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        ArrayDeque<Integer> st = new ArrayDeque();
        int n = temperatures.length;

        int [] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            int curr = temperatures[i];
            while(!st.isEmpty()){
                int k = st.peek();
                if(temperatures[k] <= curr){
                    st.pop();
                } else{
                    break;
                }
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }

        return ans;

    }
}
