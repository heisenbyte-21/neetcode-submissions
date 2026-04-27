class Solution {
    public String decodeString(String s) {
       Stack<Integer> countStack = new Stack<>();
       Stack<StringBuilder> stringStack = new Stack<>();
       int k = 0;
       StringBuilder curr = new StringBuilder();

       for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = (k * 10) + (c - '0');//2
            } else if (c == '['){
                countStack.push(k); // [2,3]
                stringStack.push(curr);// ["", "a"]
                                
                k = 0;
                curr = new StringBuilder();
            } else if(c == ']'){
                int times = countStack.pop(); //3 //2
                StringBuilder str = stringStack.pop(); //"a"//""

                for(int i = 0; i < times; i++){
                    str.append(curr);
                }
                curr = str; //abbb //abbbabbb
            } else {
                curr = curr.append(c);
            }
       }

       return curr.toString();
    }
}