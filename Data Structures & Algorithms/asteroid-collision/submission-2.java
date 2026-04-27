class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            boolean alive = true;

            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int absValue = Math.abs(asteroid);

                if(stack.peek() > absValue) {
                    alive = false;
                    break;
                } else if (stack.peek() == absValue) {
                    stack.pop();
                    alive = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            if(alive) {
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}