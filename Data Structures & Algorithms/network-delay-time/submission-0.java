class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Build graph
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new int[]{v, w});
        }

        // Distance array
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min heap -> {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currDist = curr[0];
            int node = curr[1];

            // Ignore outdated entry
            if (currDist > dist[node]) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDist = currDist + weight;

                if (newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;

                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}