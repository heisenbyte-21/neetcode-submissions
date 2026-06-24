class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int min = Math.min(w1.length(), w2.length());
            for (int j = 0; j < min; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for(char c : indegree.keySet()) {
            if (indegree.get(c).equals(0)) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            Character dependency = queue.poll();
            result.append(dependency);

            for (Character dependant : adj.get(dependency)) {
                int count = indegree.get(dependant) - 1;
                indegree.put(dependant, count);

                if(count == 0) {
                    queue.offer(dependant);
                }
            }
        }

        return (result.length() != indegree.size()) ? "" : result.toString();
    }
}
