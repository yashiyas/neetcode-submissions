class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> revOrder = new ArrayList();
        Map<Integer, List<Integer>> adjList = new HashMap();
        int[] visited = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
            visited[i] = 0;
        }

        for(int i=0; i<prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];

            adjList.get(c1).add(c2);
        }

        for(int i=0; i<numCourses; i++){
            if(! (visited[i] == 2)){
                if(!dfs(i,adjList,visited,revOrder)){
                    return new int[0];
                }
            }
        }

        int[] ans = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            ans[i] = revOrder.get(i);
        }

        return ans;
    }

    private boolean dfs(int i, Map<Integer,List<Integer>> adjList, int[] visited, List<Integer> revOrder){
        if(visited[i] == 1){
            return false;
        }

        if(visited[i] == 2){
            return true;
        }

        visited[i] = 1;

        for(int j:adjList.get(i)){

            if(!dfs(j,adjList,visited,revOrder)){
                return false;
            }
        }

        visited[i] = 2;
        revOrder.add(i);
        return true;

    }
}
