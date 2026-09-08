class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer,List<Integer>> adjList = new HashMap();
        Map<Integer,Integer> height = new HashMap();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<n; i++){
            Set<Integer> visited = new HashSet();
            visited.add(i);
            for(int j: adjList.get(i)){
                visited.add(j);
                queue.offer(j);
            }
            int currHeight = 1;
            while(!queue.isEmpty()){
                currHeight++;
                int size = queue.size();
                for(int k=0; k<size; k++){
                    int curr = queue.poll();
                    for(int neigh: adjList.get(curr)){
                        if(!visited.contains(neigh)){
                            visited.add(neigh);
                            queue.offer(neigh);
                        }
                    }
                }
            }
            height.put(i, currHeight);
        }

        int minH = n;

        for(int i=0; i<n; i++){
            int currH = height.get(i);
            if(currH < minH){
                minH = currH;
            }
        }

        List<Integer> ans = new ArrayList();

        for(int i=0; i<n; i++){
            if(height.get(i) == minH){
                ans.add(i);
            }
        }

        return ans;
        
    }
}