class MinStack {
public:
    stack<int> s;
    stack<int> minS;
    MinStack() {
    }
    
    void push(int val) {
        if( minS.empty() || val < minS.top()){
            minS.push(val);
        }
        else{
            minS.push(minS.top());
        }
        s.push(val);
    }
    
    void pop() {
        s.pop();
        minS.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return minS.top();
    }
};
