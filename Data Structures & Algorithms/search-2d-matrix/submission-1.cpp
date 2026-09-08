class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
       int m = matrix[0].size();
       int n = matrix.size();

       int low = 0;
       int high = m*n - 1; 

       while(low <= high){
        int mid = (high+low)/2;
        int r = mid/m;
        int c = mid%m;

        if(matrix[r][c] == target){
            return true;
        }

        if(matrix[r][c] < target){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
       }

       return false;
    }
};
