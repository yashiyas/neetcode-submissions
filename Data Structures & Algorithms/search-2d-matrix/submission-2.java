class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int grids = rows*columns;

        int r = 0;
        int l = grids-1;

        while(r>=0 && l<grids && r<=l){
            int mid = r + (l-r)/2;

            int r0 = mid/columns;
            int c0 = mid-columns*r0;

            int val = matrix[r0][c0];

            if(val == target){
                return true;
            }

            if(val < target){
                r = mid+1;
            }
            else{
                l = mid - 1;
            }
        }

        return false;


        
    }
}
