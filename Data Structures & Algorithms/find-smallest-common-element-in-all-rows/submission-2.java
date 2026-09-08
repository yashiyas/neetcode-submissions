class Solution {
    public int smallestCommonElement(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] values = new int[m];
        int[] indexes = new int[m];

        for(int i=0; i<m; i++){
            values[i] = mat[i][0];
        }

        int currMin = Integer.MAX_VALUE;

        while(true){
            if(allValuesSame(values)){
                return values[0];
            }
            else{
                currMin = getCurrMin(values);
                if(!update(values,indexes, currMin, mat)){
                    return -1;
                }
            }
        }
        
    }

    private boolean allValuesSame(int[] values){
        for(int i=0; i<values.length-1; i++){
            if(values[i] != values[i+1]){
                return false;
            }
        }

        return true;
    }

    private int getCurrMin(int[] values){
        int currMin = values[0];
        for(int i=0; i<values.length; i++){
            currMin = Math.min(currMin, values[i]);
        }

        return currMin;
    }

    private boolean update(int[] values, int[] indexes, int currMin, int[][] mat){
        int n = mat[0].length;
        for(int i=0; i<values.length; i++){
            if(values[i] == currMin){
                if(indexes[i] == n-1){
                    return false;
                }
                indexes[i] = indexes[i]+1;
                values[i] = mat[i][indexes[i]];
            }
        }

        return true;


    }
}
