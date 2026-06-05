class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {

            graph.get(time[0])
                 .add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});

        boolean[] visited = new boolean[n + 1];

        int time = 0;
        int visitedCount = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currTime = curr[0];
            int node = curr[1];

            // already finalized
            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            visitedCount++;

            time = Math.max(time, currTime);

            for (int[] neighbor : graph.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (!visited[nextNode]) {

                    pq.offer(
                        new int[]{
                            currTime + weight,
                            nextNode
                        }
                    );
                }
            }
        }

        return visitedCount == n ? time : -1;
    }
}