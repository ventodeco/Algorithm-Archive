class Solution {

    private static Integer NOT_VISITED = 0;
    private static Integer VISITING = 1;
    private static Integer VISITED = 2;

    private boolean isCycled;
    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> nodeStatus;
    private List<Integer> courseOrder;

    private void dfs(int course) {
        
        if (isCycled) {
            return;
        }

        nodeStatus.put(course, VISITING);
        List<Integer> neighbors = graph.get(course);

        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (nodeStatus.get(neighbor) == NOT_VISITED) {
                    dfs(neighbor);
                } else if (nodeStatus.get(neighbor) == VISITING) {
                    isCycled = true;
                }
            }
        }

        nodeStatus.put(course, VISITED);
        courseOrder.add(course);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        isCycled = false;
        graph = new HashMap<>();
        nodeStatus = new HashMap<>();
        courseOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            nodeStatus.put(i, NOT_VISITED);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int destination = prerequisites[i][0];

            List<Integer> list = graph.getOrDefault(source, new ArrayList<>());
            list.add(destination);
            graph.put(source, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (nodeStatus.get(i) == NOT_VISITED) {
                dfs(i);
            }
        }

        if (isCycled) {
            return new int[]{};
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = courseOrder.get(numCourses - i - 1);
        }

        return result;
    }
}
