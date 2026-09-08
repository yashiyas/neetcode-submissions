class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adjList = new HashMap();
        Map<Integer,Integer> indegree = new HashMap();

        for(int i=0; i<numCourses; i++){
            adjList.put(i, new ArrayList());
            indegree.put(i,0);
        }

        

        for(int i=0; i<prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];

            adjList.get(c2).add(c1);
            int fre = indegree.get(c1)+1;
            indegree.put(c1,fre);
        }

        Queue<Integer> que = new LinkedList();


        for(int i=0; i<numCourses; i++){
            if(indegree.get(i) == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            Integer top = que.poll();
            for(int i:adjList.get(top)){
                int fre = indegree.get(i)-1;
                indegree.put(i, fre);
                if(indegree.get(i) == 0){
                    que.offer(i);
                }
            }
        }

        for(int i=0; i<numCourses; i++){
            if(indegree.get(i) != 0){
                return false;
            }
        }

        return true;

        

    }

   
}
