class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i <  temperatures.length; i++){
            // [38, 39, 40, 31]
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int indx = stack.pop();
                // res[indx] = temperatures[i];
                res[indx] = i - indx;
            }

            stack.push(i);
        }

        return res;
    }
}
