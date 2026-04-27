class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int popped = stack.pop();
                int height = heights[popped];
                int width;

                if(stack.isEmpty()){
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                max = Math.max(max, height*width);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int popped = stack.pop();
            int height = heights[popped];
            int width;

            if(stack.isEmpty()){
                width = heights.length;
            } else {
                width = heights.length - stack.peek() - 1;
            }

            max = Math.max(max, height*width);
        }

        return max;
    }
}
