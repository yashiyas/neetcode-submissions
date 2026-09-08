class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> st = new ArrayDeque();

        for(int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if(!isOperand(s)){
                st.push(Integer.valueOf(s));
            }
            else{
                int s1 = st.pop();
                int s2 = st.pop();
                int s3 = evaluate(s1,s2,s);
                st.push(s3);
            }
        }
        return st.pop(); 
    }

    private Integer evaluate(int s1, int s2, String operand){
        int ans;
         switch(operand){
            case "+":  ans = s2+s1;break;
            case "-":  ans = s2-s1;break;
            case "*":  ans = s2*s1;break;
            default:  ans = s2/s1;
        }
        return ans;
    }

    private boolean isOperand(String s){
        System.out.println(s);
        return Set.of("+", "-", "/", "*").contains(s);
    }
}
