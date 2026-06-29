class Solution {

    int[] parent;
    int[] rank;

    public boolean validTree(int n, int[][] edges) {

        // A tree must have exactly n-1 edges
        if (edges.length != n - 1)
            return false;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false; // cycle found
            }
        }

        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    private boolean union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return false;

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}