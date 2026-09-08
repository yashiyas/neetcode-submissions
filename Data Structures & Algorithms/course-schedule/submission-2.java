class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];

            adjList.get(src).add(dest);
        }

        
        for(int i=0; i<numCourses; i++){
            Set<Integer> visited = new HashSet();
            if(!dfs(i,visited,adjList)){
                return false;
            }
        }

        return true;
    
    }

    private boolean dfs(int val, Set<Integer> visited, Map<Integer, List<Integer>> adjList){
        if(visited.contains(val)){
            return false;
        }

        if(adjList.get(val).isEmpty()){
            return true;
        }

        visited.add(val);

        for(int i:adjList.get(val)){
            if(!dfs(i,visited,adjList)){
                return false; 
            }
        }
        visited.remove(val);
        return true;
    }

   
}
