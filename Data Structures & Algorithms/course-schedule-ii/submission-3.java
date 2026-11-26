class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ans = new int[numCourses];

        int[] inorder = new int[numCourses];

        Map<Integer, List<Integer>> adjList = new HashMap();

        for(int i=0; i<prerequisites.length; i++){
            int v1 = prerequisites[i][0];
            int v2 = prerequisites[i][1];

            adjList.computeIfAbsent(v2, k-> new ArrayList());
            adjList.get(v2).add(v1);
            inorder[v1]+=1;
        }

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<numCourses; i++){
            if(inorder[i] == 0){
                queue.add(i);
            }
        }

        int k = 0;

        while(!queue.isEmpty()){

            int course = queue.poll();
            ans[k] = course;
            k++;
            List<Integer> preReqs = adjList.getOrDefault(course, new ArrayList());

            for(int i: preReqs){
                inorder[i]-=1;
                if(inorder[i] == 0){
                    queue.add(i);
                }
            }

        }

        if(k == numCourses){
            return ans;
        }

        return new int[0];
        
    }
}
