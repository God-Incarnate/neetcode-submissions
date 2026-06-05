class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // Initialize DSU
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // cycle found
            if (find(u, parent) == find(v, parent)) {
                return edge;
            }

            union(u, v, parent, rank);
        }

        return new int[0];
    }

    private int find(int x, int[] parent) {

        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    private void union(int x, int y,
                       int[] parent,
                       int[] rank) {

        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX == rootY) {
            return;
        }

        // Union by rank
        if (rank[rootX] < rank[rootY]) {

            parent[rootX] = rootY;

        } else if (rank[rootX] > rank[rootY]) {

            parent[rootY] = rootX;

        } else {

            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}