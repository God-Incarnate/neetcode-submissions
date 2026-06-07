class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.computeIfAbsent(from, x -> new ArrayList<>())
                 .add(new int[]{to, price});
        }

        // min cost to reach each node
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;

        Queue<int[]> queue = new LinkedList<>();

        // {city, totalCost}
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {

            int size = queue.size();

            // temporary array for this level
            int[] temp = cost.clone();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int city = current[0];
                int currentCost = current[1];

                if (!graph.containsKey(city)) {
                    continue;
                }

                for (int[] neighbor : graph.get(city)) {

                    int nextCity = neighbor[0];
                    int flightCost = neighbor[1];

                    int newCost = currentCost + flightCost;

                    // Relaxation
                    if (newCost < temp[nextCity]) {

                        temp[nextCity] = newCost;

                        queue.offer(new int[]{
                            nextCity,
                            newCost
                        });
                    }
                }
            }

            cost = temp;
            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE
               ? -1
               : cost[dst];
    }
}