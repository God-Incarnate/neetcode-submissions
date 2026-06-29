class Solution {

    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have exactly n-1 edges
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(0, -1, graph, visited))
            return false;

        // Check connectivity
        for (boolean node : visited) {
            if (!node)
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent,
                        List<List<Integer>> graph,
                        boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (!dfs(neighbor, node, graph, visited))
                    return false;

            } else if (neighbor != parent) {

                // Found a cycle
                return false;
            }
        }

        return true;
    }
}