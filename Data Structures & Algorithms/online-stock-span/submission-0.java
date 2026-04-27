class Pair{
    int stock;
    int span;

    Pair(int stock, int span){
        this.stock = stock;
        this.span = span;
    }
}

class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().stock <= price){
            Pair node = stack.pop();
            span += node.span;
        }
        Pair node = new Pair(price, span);
        stack.push(node);
        return node.span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */