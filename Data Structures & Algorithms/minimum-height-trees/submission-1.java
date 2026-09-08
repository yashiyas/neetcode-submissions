class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer,List<Integer>> adjList = new HashMap();
        Map<Integer,Integer> height = new HashMap();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
            height.put(i,0);
        }

        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
            height.put(n1, height.get(n1)+1);
            height.put(n2, height.get(n2)+1);
        }

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<n; i++){
            if(height.get(i) == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty() && height.size() > 2){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int curr = queue.poll();
                height.remove(curr);
                for(int neigh: adjList.get(curr)){
                    if(height.containsKey(neigh)){
                        int h = height.get(neigh) - 1;
                        if(h==1){
                            queue.offer(neigh);
                        }
                        height.put(neigh,h);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList();
        for(int h: height.keySet()){
            ans.add(h);
        }

        return ans;


        
    }
}