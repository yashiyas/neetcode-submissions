class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Weight>> adjList = new HashMap();

        for(int i=0; i<equations.size(); i++){
            String node1 = equations.get(i).get(0);
            String node2 = equations.get(i).get(1);

            adjList.computeIfAbsent(node1, k-> new ArrayList());
            adjList.computeIfAbsent(node2, k-> new ArrayList());

            adjList.get(node1).add(new Weight(node2, values[i]));
            adjList.get(node2).add(new Weight(node1, 1/values[i]));

        }

        int n = queries.size();

        double[] ans = new double[n];

        for(int i=0; i<n; i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if(!adjList.containsKey(from) || !adjList.containsKey(to)){
                ans[i] = -1;
                continue;
            }

            if(from == to){
                ans[i] = 1;
                continue;
            }

            Set<String> visited = new HashSet();
            visited.add(from);

            ans[i] = getPath(from, to, adjList, visited);


        }

        return ans;
        
    }

    private double getPath(String curr, String target, Map<String, List<Weight>> adjList, Set<String> visited){
        if(curr.equals(target)){
            return 1;
        }

        boolean found = false;
        double path = 1;

        for(int i=0; i<adjList.get(curr).size(); i++){
            Weight weight = adjList.get(curr).get(i);
            if(!visited.contains(weight.node)){
                visited.add(weight.node);
                path = (path*weight.val)*getPath(weight.node,target,adjList,visited);
                if(path < 0){
                    path = 1;
                    visited.remove(weight.node);
                }else{
                    return path;
                }
            }

        }

        return -1;
    }

    class Weight{
        String node;
        double val;

        Weight(String node, double val){
            this.node = node;
            this.val = val;
        }
    }
}