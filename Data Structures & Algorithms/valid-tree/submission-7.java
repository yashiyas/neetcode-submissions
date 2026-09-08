class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){
            return false;
        }

        Map<Integer,List<Integer>> adjList = new HashMap();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        int[] visit = new int[n];

        if(!dfs(0,adjList,visit,-1)){
            return false;
        }
        
        for(int i=0; i<n; i++){
            if(visit[i] == 0){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int i, Map<Integer,List<Integer>> adjList, int[] visit, int parent){
        if(visit[i] == 1){
            return false;
        }

        visit[i] = 1;

        for(int j: adjList.get(i)){
            if(j == parent){
                continue;
            }
            if(!dfs(j,adjList,visit,i)){
                return false;
            }
        }

        return true;
    }

   
}