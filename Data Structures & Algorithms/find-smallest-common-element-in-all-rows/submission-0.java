class Solution {
    public int smallestCommonElement(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        if(m == 1){
            return mat[0][0];
        }

        for(int i=0; i<n; i++){

            // for each mat[0][i], check if the element is present in other rows

            int element = mat[0][i];

            if(presentInAll(mat, element)){
                return element;
            }


        }

        return -1;
        
    }


    private boolean presentInAll(int[][] mat, int element){

        for(int i=1; i<mat.length; i++){
            int[] arr = mat[i];
            if(!findElement(arr, element)){
                return false;
            }
        }

        return true;
        
    }

    private boolean findElement(int[] arr, int element){
        int l = 0;
        int r = arr.length - 1;

        while(l <=r){
            int mid = (r-l)/2 + l;

            if(arr[mid] == element){
                return true;
            }

            if(arr[mid] > element){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return false;
    }
}
