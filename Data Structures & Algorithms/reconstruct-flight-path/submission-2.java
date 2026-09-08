class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String,List<String>> adjList = new HashMap();
        List<String> ans = new ArrayList();

        Collections.sort(tickets, (a,b) -> {
            int cmp = a.get(0).compareTo(b.get(0));
            if (cmp != 0) {
                return cmp;
            }
            return a.get(1).compareTo(b.get(1));
        });

        for(List<String> ticket: tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);

            if(!adjList.containsKey(src)){
                adjList.put(src, new ArrayList());
            }
            if(!adjList.containsKey(dest)){
                adjList.put(dest, new ArrayList());
            }

            adjList.get(src).add(dest);
        }

        int target = tickets.size() + 1;
       
        if(dfs("JFK", adjList, ans,target)){
            return ans;
        }
    
        
        return ans;
    }

    private boolean dfs(String curr, Map<String,List<String>> adjList, List<String> ans, int target){
        ans.add(curr);

        if(ans.size() == target){
            return true;
        }

        if(adjList.get(curr).isEmpty()){
            ans.remove(ans.size()-1);

            return false;
        }

        Map<String,List<String>> temp = new HashMap(adjList);

        for(int i=0; i<adjList.get(curr).size(); i++){
            String nextStop = adjList.get(curr).get(i);
            temp.get(curr).remove(i);
            if(dfs(nextStop,temp,ans,target)){
                return true;
            }
            temp.get(curr).add(i,nextStop);
        }

        ans.remove(ans.size()-1);

        return false;

    }
}
