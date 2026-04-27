class FreqStack {
    int maxFreq;
    HashMap<Integer, Integer> valueFreqMap;
    HashMap<Integer, Stack<Integer>> freqValMap;

    public FreqStack() {
        maxFreq = 0;
        valueFreqMap = new HashMap<>();
        freqValMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = valueFreqMap.getOrDefault(val, 0) + 1;
        valueFreqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);

        freqValMap
            .computeIfAbsent(freq, k -> new Stack<Integer>())
            .push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = freqValMap.get(maxFreq);
        int val = stack.pop();

        valueFreqMap.put(val, valueFreqMap.get(val) - 1);
        
        if(stack.empty()){
            freqValMap.remove(maxFreq);
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