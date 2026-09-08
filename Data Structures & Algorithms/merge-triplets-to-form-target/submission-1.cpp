class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        int n = triplets.size();
        vector<vector<int>> filterTriplets;
        for(int i=0; i<n; i++){
            vector<int> curr = triplets[i];
            if(curr[0] > target[0] || curr[1] > target[1] || curr[2] > target[2]){
                continue;
            }
            filterTriplets.push_back(curr);
        }

        if(filterTriplets.size() == 0){
            return false;
        }

        vector<bool> present(3,false);

        for(int i=0; i<filterTriplets.size(); i++){
            vector<int> curr = filterTriplets[i];
            if(curr[0] == target[0]){
                present[0] = true;
            }
            if(curr[1] == target[1]){
                present[1] = true;
            }
            if(curr[2] == target[2]){
                present[2] = true;
            }
        }

        for(int i=0; i<3; i++){
            if(!present[i]){
                return false;
            }
        }

        return true;
    }
};
