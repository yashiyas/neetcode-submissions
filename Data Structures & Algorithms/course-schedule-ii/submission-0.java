class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] order = new int[numCourses];
        int[] indegree = new int[numCourses];
        int x=0;

        Map<Integer,List<Integer>> adjList = new HashMap();

        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
            indegree[i]=0;
        }

        for(int i=0; i<prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];

            adjList.get(c2).add(c1);
            indegree[c1]++;
        }

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.offer(i);
                order[x]=i;
                x++;
            }
        }

        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i: adjList.get(top)){
                indegree[i]--;
                if(indegree[i] == 0){
                    order[x] = i;
                    x++;
                    queue.offer(i);
                }
            }
        }

        if(x==numCourses){
            return order;
        }

        return new int[0];

        
    }
}
