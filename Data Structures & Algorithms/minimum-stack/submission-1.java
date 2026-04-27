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
        if(mainStack.isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }

        int val = mainStack.pop();

        if(minStack.peek() == val){
            minStack.pop();
        }
    }
    
    public int top() {
        if(mainStack.isEmpty()){
            return -1;
        }

        return mainStack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }

        return minStack.peek();
    }
}
