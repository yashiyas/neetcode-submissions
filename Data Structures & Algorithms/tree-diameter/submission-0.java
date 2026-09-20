class Solution {

    Map<Integer, List<Integer>> adjList = new HashMap();
    int diameter = 0;

    public int treeDiameter(int[][] edges) {

        int n = edges.length +1;

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int[] edge: edges){
            int i = edge[0];
            int j = edge[1];

            adjList.get(i).add(j);
            adjList.get(j).add(i);

        }

        solve(0,-1);

        return diameter;

        
        
    }

    private int solve(int node, int parent){

        int longest = 0;
        int second = 0;

        for(int i: adjList.get(node)){
            if(i == parent){
                continue;
            }

            int curr = solve(i, node);

            if(curr > longest){
                second = longest;
                longest = curr;
            }else if(curr > second){
                second = curr;
            }
        }

        int currDia = longest+second;
        diameter = Math.max(diameter, currDia);

        return 1+longest;

    }
}