class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            // If path already exists -> cycle
            if (hasPath(u, v, graph, visited)) {
                return edge;
            }

            // Add edge
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasPath(int src,
                            int target,
                            List<List<Integer>> graph,
                            boolean[] visited) {

        if (src == target) {
            return true;
        }

        visited[src] = true;

        for (int neighbor : graph.get(src)) {

            if (!visited[neighbor]) {

                if (hasPath(neighbor, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}