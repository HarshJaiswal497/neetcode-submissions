class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        if(minStk.isEmpty()){
            minStk.push(val);
        }else{
            int min = Math.min(val, minStk.peek());
            minStk.push(min);
        }
        stk.push(val);
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            stk.pop();
        }
        if(!minStk.isEmpty()){
            minStk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
