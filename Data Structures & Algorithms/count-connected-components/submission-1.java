class Solution {
    public int countComponents(int n, int[][] edges) {

        int ans = 0;

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

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,visited,adjList);
                ans++;
            }
        }

        return ans;

    }

    private void dfs(int i, boolean[] visited,  Map<Integer,List<Integer>> adjList){
        if(visited[i]){
            return;
        }

        visited[i] = true;

        for(int j: adjList.get(i)){
            if(!visited[j]){
                dfs(j,visited,adjList);
            }
        }
    }
}