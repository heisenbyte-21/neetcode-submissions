class Solution {
    public void decode(Stack<Character> stack){

        String encodedString = "";
        while(!stack.isEmpty() && Character.isLetter(stack.peek())){
            encodedString += Character.toString(stack.pop());
        }

        encodedString = new StringBuilder(encodedString).reverse().toString();
        
        if(!stack.isEmpty() && stack.peek() == '[' && Character.isDigit(stack.get(stack.size() - 2))){
            stack.pop();

            String num = "";
            while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                num += Character.toString(stack.pop());
            }
            num = new StringBuilder(num).reverse().toString();

            encodedString = encodedString.repeat(Integer.parseInt(num));
            char[] charArray = encodedString.toCharArray();
            for(char res : charArray){
                stack.push(res);
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