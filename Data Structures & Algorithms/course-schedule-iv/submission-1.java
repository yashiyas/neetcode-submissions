class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Map<Integer,List<Integer>> adjList = new HashMap();
        List<Set<Integer>> preReqs = new ArrayList();

        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
            preReqs.add(new HashSet());
        }

        for(int i=0; i< prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            adjList.get(c2).add(c1);
        }

        List<Boolean> ans = new ArrayList();
        boolean[] visited = new boolean[numCourses];

        for(int i=0; i<queries.length; i++){
            int c1 = queries[i][0];
            int c2 = queries[i][1];
            ans.add(dfs(c2,visited,preReqs,adjList).contains(c1));
        }

        return ans;
        
    }

    private Set<Integer> dfs(int i, boolean[] visited, List<Set<Integer>> preReqs, Map<Integer, List<Integer>> adjList){
        if(visited[i]){
            return preReqs.get(i);
        }

        Set<Integer> currPreReq = new HashSet();

        for(int j: adjList.get(i)){
            currPreReq.addAll(dfs(j,visited,preReqs,adjList));
        }

        visited[i] = true;
        currPreReq.add(i);
        preReqs.set(i,currPreReq);
        return currPreReq;

    }
}