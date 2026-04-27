class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sortedRes = getSortedString(strs[i]);

            if (result.containsKey(sortedRes)) {
                result.get(sortedRes).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(sortedRes, list);
            }
        }

        return new ArrayList<>(result.values());
    }

    public String getSortedString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
