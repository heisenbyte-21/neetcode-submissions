class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        count = n;

        Arrays.setAll(parent, i -> i);
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return x = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count;
    }
}
