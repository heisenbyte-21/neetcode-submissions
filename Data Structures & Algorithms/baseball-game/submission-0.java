class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum;
        for(String c : operations){
            switch(c) {
                case "+":
                    sum = stack.peek() + stack.get(stack.size() - 2);
                    stack.push(sum);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
                    break;
            }
        }

        sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}