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
        int currSpan = 1;

        while(!stack.isEmpty() && stack.peek().stock <= price){
            currSpan += stack.pop().span;
        }

        stack.push(new Pair(price, currSpan));
        return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */