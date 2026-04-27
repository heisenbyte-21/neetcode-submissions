class FreqStack {
    int maxFreq;
    HashMap<Integer, Integer> valueFreqMap;
    HashMap<Integer, Stack<Integer>> freqStackMap;

    public FreqStack() {
        maxFreq = 0;
        valueFreqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = valueFreqMap.getOrDefault(val, 0) + 1;
        valueFreqMap.put(val, freq);

        maxFreq = Math.max(freq, maxFreq);

        freqStackMap
            .computeIfAbsent(freq, k -> new Stack<>())
            .push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = freqStackMap.get(maxFreq);
        int val = stack.pop();

        valueFreqMap.put(val, valueFreqMap.get(val) - 1);

        if(stack.isEmpty()){
            freqStackMap.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */