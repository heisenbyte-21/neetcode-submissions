class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;

    public MinStack() {
        minStack = new Stack<>();
        mainStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            if(minStack.peek() >= val){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(mainStack.empty()){
            throw new RuntimeException("Stack underflow");
        }

        int val = mainStack.pop();
        if(!minStack.isEmpty() && val == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        if(mainStack.empty()){
            return -1;
        }

        return mainStack.peek();
    }
    
    public int getMin() {
        if(minStack.empty()){
            return -1;
        }

        return minStack.peek();
    }
}
