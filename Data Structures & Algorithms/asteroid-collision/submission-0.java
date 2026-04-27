class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i : asteroids){
            boolean alive = true;

            while(!stack.isEmpty() && stack.peek() > 0 && i < 0){
                int peek = stack.peek();

                if(peek > Math.abs(i)){
                    alive = false;
                    break;
                }
                
                if(peek < Math.abs(i)){
                    stack.pop();
                    continue;
                }

                if(peek == Math.abs(i)){
                    alive = false;
                    stack.pop();
                    break;
                }
            }

            if(alive){
                stack.push(i);
            }
        }

        int[] res = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}