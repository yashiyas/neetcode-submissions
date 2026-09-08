class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for(int i=0; i< s.length(); i++){
            char c1 = s.charAt(i);
            System.out.println(c1);
            if(openparanthesis(c1)){
                System.out.println("Open");
                st.push(c1);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char c2 = st.pop();
                System.out.println(c2);
                if(!validPair(c1,c2)){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    private boolean openparanthesis(char c){
        return c== '{' || c == '[' || c == '(';
    }

    private boolean validPair(char c1, char c2){
        System.out.println(c1+c2);
        switch(c1){
            case '}': return c2 == '{';
            case ')': return c2 == '(';
            case ']': return c2 == '[';
            default: return false;
        }
    }
}
