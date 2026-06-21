class Solution {
    private List<List<Integer>> getGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    private boolean hasCycle(List<List<Integer>> graph, int parent, int node, boolean[] visited) {
        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (neighbour == parent) {
                continue;
            }

            if (visited[neighbour] || hasCycle(graph, node, neighbour, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = getGraph(n, edges);
        boolean[] visited = new boolean[n];

        if (hasCycle(graph, -1, 0, visited)) {
            return false;
        }

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }
}
