class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {

        this.s1 = new Stack();
        this.s2 = new Stack();
        
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty()){
            s2.push(val);
        }else{
            int curr = s2.peek();
            if(curr>val){
                s2.push(val);
            }else{
                s2.push(curr);
            }
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
        
    }
    
    public int top() {

        return s1.peek();
        
    }
    
    public int getMin() {

        return s2.peek();
        
    }
}
