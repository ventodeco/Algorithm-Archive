class Solution {

    private static int NOT_VISITED = 0;
    private static int VISITING = 1;
    private static int VISITED = 2;
    private Map<Integer, List<Integer>> listPrereqMap;
    private Map<Integer, Integer> checkStatus;
    private Deque<Integer> keepResult;
    private Boolean isCycled;

    private void checkCourse(int course) {
        List<Integer> listPrereq = listPrereqMap.get(course);

        if (listPrereq == null) {
            keepResult.addFirst(course);
            checkStatus.put(course, VISITED);
            return;
        }

        for (Integer courseReq : listPrereq) {
            if (checkStatus.get(courseReq) == NOT_VISITED) {
                checkStatus.put(courseReq, VISITING);
                checkCourse(courseReq);
            } else if (checkStatus.get(courseReq) == VISITING) {
                isCycled = true; 
                return;
            }
        }
        
        checkStatus.put(course, VISITED);
        keepResult.addFirst(course);

        return;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        checkStatus = new HashMap<>();
        listPrereqMap = new HashMap<>();
        keepResult = new ArrayDeque<>();
        isCycled = false;

        for (int i = 0; i < numCourses; i++) {
            checkStatus.put(i, NOT_VISITED);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int reqPreq = prerequisites[i][1];
            int course = prerequisites[i][0];

            List<Integer> list = listPrereqMap.getOrDefault(course, new ArrayList<>());
            list.add(reqPreq);
            listPrereqMap.put(course, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (checkStatus.get(i) == NOT_VISITED) {
                checkStatus.put(i, VISITING);
                checkCourse(i);
            }
        }
        
        if (isCycled) {
            return new int[]{};
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = keepResult.removeLast();
        }

        return result;
    }
}