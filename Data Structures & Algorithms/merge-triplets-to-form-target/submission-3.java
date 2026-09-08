class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        List<int[]> filtered = new ArrayList();

        for(int i=0; i<triplets.length; i++){
            if((target[0] < triplets[i][0]) || (target[1]<triplets[i][1]) || (target[2] < triplets[i][2])){
                continue;
            }
            filtered.add(triplets[i]);
        }

        if(filtered.size() == 0){
            return false;
        }

        int[] merged = filtered.get(0);

        for(int i=1; i<filtered.size(); i++){
            int[] curr = filtered.get(i);
            merged[0] = Math.max(merged[0], curr[0]);
            merged[1] = Math.max(merged[1], curr[1]);
            merged[2] = Math.max(merged[2], curr[2]);
        }

        for(int i=0; i<3; i++){
            if(merged[i] != target[i]){
                return false;
            }
        }

        return true;

        
    }
}
