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

        Set<Integer> visited = new HashSet();
        for(int i=0; i<numCourses; i++){
            Set<Integer> visiting = new HashSet();
            if(!visited.contains(i) && !dfs(i,visiting,adjList,visited)){
                return false;
            }
        }

        return true;
    
    }

    private boolean dfs(int val, Set<Integer> visiting, Map<Integer, List<Integer>> adjList, Set<Integer> visited){
        if(visiting.contains(val)){
            return false;
        }

        if(visited.contains(val)){
            return true;
        }

        if(adjList.get(val).isEmpty()){
            return true;
        }

        visiting.add(val);

        for(int i:adjList.get(val)){
            if(!dfs(i,visiting,adjList, visited)){
                return false; 
            }
        }
        visiting.remove(val);
        visited.add(val);
        return true;
    }

   
}
