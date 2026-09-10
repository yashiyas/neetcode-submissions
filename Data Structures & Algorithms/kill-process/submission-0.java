class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> ans = new ArrayList();

        Map<Integer, List<Integer>> childMap = new HashMap();

        Map<Integer, List<Integer>> parentMap = new HashMap();

        for(int i=0; i<ppid.size(); i++){
            if(ppid.get(i) == 0){
                if(kill == pid.get(i)){
                    return pid;
                }
                continue;
            }
            parentMap.computeIfAbsent(ppid.get(i), k-> new ArrayList());
            parentMap.get(ppid.get(i)).add(pid.get(i));
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(kill);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int killId = queue.poll();
                ans.add(killId);
                if(parentMap.containsKey(killId)){
                    for(int childId: parentMap.get(killId)){
                        queue.add(childId);
                    }
                }
            }

        }

        return ans;
        
    }
}
