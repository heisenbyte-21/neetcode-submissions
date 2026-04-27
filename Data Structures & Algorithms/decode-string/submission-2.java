class Solution {
    public void decode(Stack<Character> stack){
        String letters = "";
        while(!stack.isEmpty() && Character.isLetter(stack.peek())){
            letters += stack.pop();
        }
        letters = new StringBuilder(letters).reverse().toString();

        if(!stack.isEmpty() && stack.peek() == '[' && Character.isDigit(stack.get(stack.size() - 2))){
            stack.pop();

            String num = "";
            while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                num += stack.pop();
            }
            num = new StringBuilder(num).reverse().toString();

            letters = letters.repeat(Integer.parseInt(num));

            for(char c : letters.toCharArray()){
                stack.push(c);
            }
        }
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == ']'){
                decode(stack);
                continue;
            } else {
                stack.push(c);
            }
        }

        String result = "";
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return new StringBuilder(result).reverse().toString();
    }
}