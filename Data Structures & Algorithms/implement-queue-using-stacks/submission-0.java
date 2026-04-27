class MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
    }
    
    public int pop() {
        if(tempStack.isEmpty()){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }

        return tempStack.pop();
    }
    
    public int peek() {
        if(tempStack.isEmpty()){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }

        return tempStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty() && tempStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */