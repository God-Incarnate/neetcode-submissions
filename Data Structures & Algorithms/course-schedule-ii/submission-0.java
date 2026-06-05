class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all courses with indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // BFS
        while (!queue.isEmpty()) {

            int curr = queue.poll();

            order[index++] = curr;

            for (int neighbor : graph.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}