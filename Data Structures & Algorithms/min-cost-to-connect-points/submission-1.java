    // ---------------Kruskal’s Algorithm Idea----------------
    // Generate all possible edges.
    // Sort edges by cost.
    // Pick the smallest edge that does NOT form a cycle.
    // Use Union Find to detect cycles.
    // Stop after selecting n - 1 edges.
class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        // Generate all edges
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int distance =
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{distance, i, j});
            }
        }

        // Sort by edge weight
        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {

            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            // If no cycle
            if (find(u, parent) != find(v, parent)) {

                union(u, v, parent, rank);

                totalCost += cost;

                edgesUsed++;

                // MST complete
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }

    private int find(int x, int[] parent) {

        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    private void union(int x,
                       int y,
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
