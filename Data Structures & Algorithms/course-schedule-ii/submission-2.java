class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ans = new int[numCourses];

        Map<Integer, List<Integer>> dependencyMap = new HashMap();
        Map<Integer,Integer> inorderMap = new HashMap();

        for(int i=0; i<numCourses; i++){
            dependencyMap.put(i, new ArrayList());
            inorderMap.put(i,0);
        }

        

        for(int[] preReq: prerequisites){
            int u = preReq[0];
            int v = preReq[1];

            dependencyMap.get(v).add(u);
            inorderMap.put(u, inorderMap.get(u)+1);
        }

        Queue<Integer> queue = new LinkedList();

        int index = 0;

        for(int i=0; i<numCourses; i++){
            if(inorderMap.get(i) == 0){
                inorderMap.remove(i);
                queue.offer(i);
                ans[index] = i;
                index++;
            }
        }

        while(!queue.isEmpty()){
            Integer curr = queue.poll();

            for(int i=0; i<dependencyMap.get(curr).size(); i++){
                int frq = inorderMap.get(dependencyMap.get(curr).get(i)) - 1;
                if(frq == 0){
                    queue.offer(dependencyMap.get(curr).get(i));
                    ans[index] = dependencyMap.get(curr).get(i);
                    index++;
                    inorderMap.remove(dependencyMap.get(curr).get(i));
                }else{
                    inorderMap.put(dependencyMap.get(curr).get(i), frq);
                }
            }
        }

        if(inorderMap.isEmpty()){
            return ans;
        }

        return new int[0];

        
    }
}
