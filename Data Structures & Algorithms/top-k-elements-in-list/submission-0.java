class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }

        return frequency.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue()) // descending by frequency
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
