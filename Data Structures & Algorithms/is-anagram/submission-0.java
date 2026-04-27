
class Solution {
    public boolean isAnagram(String s, String t) {
        // Base case: if lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // Count characters in the first string
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Count characters in the second string
        for (char ch : t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Compare the two maps
        for (Character key : map.keySet()) {
            if (!(map2.containsKey(key) && map2.get(key).equals(map.get(key)))) {
                return false;
            }
        }

        return true;
    }
}