class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            int min = minStack.peek();
            if(val <= min){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(mainStack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        int element = mainStack.pop();
        if(minStack.peek() == element){
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
