class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        UnionFind uf = new UnionFind(n);

        List<List<String>> ans = new ArrayList();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(areAccountsSame(i, j, accounts)){
                    uf.union(i,j);
                }
            }
        }

        // Step 2: Group emails by their root account
        Map<Integer, Set<String>> merged = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int parent = uf.find(i);

            if (!merged.containsKey(parent)) {
                merged.put(parent, new HashSet<>());
            }

            for (int j = 1; j < accounts.get(i).size(); j++) {
                merged.get(parent).add(accounts.get(i).get(j));
            }
        }

        for(Map.Entry<Integer,Set<String>> entry: merged.entrySet()){
            List<String> curr = new ArrayList();
            int account = entry.getKey();

            curr.add(accounts.get(account).get(0));

            for(String email: entry.getValue()){
                curr.add(email);
            }

            ans.add(curr);

        }

        return ans;


        
    }

    private boolean areAccountsSame(int a1, int a2, List<List<String>> accounts){

        List<String> accounts1 = accounts.get(a1);
        List<String> accounts2 = accounts.get(a2);

        for(int i=1; i<accounts2.size(); i++){
            if(accounts1.contains(accounts2.get(i))){
                return true;
            }
        }

        return false;

    }

    class UnionFind{
        Map<Integer,Integer> parent;
        Map<Integer,Integer> rank;

        public UnionFind(int n){
            this.parent = new HashMap();
            this.rank = new HashMap();

            for(int i=0; i<n; i++){
                this.parent.put(i,i);
                this.rank.put(i,0);
            }
        }

        public int find(int node){
            if(parent.get(node) != node){
                parent.put(node, find(parent.get(node)));
            }

            return parent.get(node);
        }

        public void union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2){
                return;
            }

            int r1 = rank.get(p1);
            int r2 = rank.get(p2);

            if(r1 < r2){
                parent.put(p1,p2);
            }else if(r1 > r2){
                parent.put(p2,p1);
            }else{
                parent.put(p2,p1);
                rank.put(p1, r1+1);
            }
        }
    }
}