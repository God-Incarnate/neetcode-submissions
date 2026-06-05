//Kahn's algorithm problem - This problem is detecting whether a 
//                           directed graph contains a cycle.

//This is a classic Topological Sort (BFS / Kahn’s Algorithm) problem.
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        // Add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        // BFS
        while (!queue.isEmpty()) {

            int curr = queue.poll();

            completed++;

            for (int neighbor : graph.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completed == numCourses;
    }
}
