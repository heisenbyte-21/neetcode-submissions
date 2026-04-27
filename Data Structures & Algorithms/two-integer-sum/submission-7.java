
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Stores number and its index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Return indices of the complement and current number
            }
            map.put(nums[i], i); // Store the current number with its index
        }
        return new int[] {};
    }
}
