class Solution {
public:
    static bool myComp(vector<int> &v1, vector<int> &v2){
        return v1[0] < v2[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), myComp);

        int n = intervals.size();

        vector<int> last(2);
        last[0] = -1;
        last[1] = -1;
        vector<vector<int>> ans;

        for(int i=0; i<n; i++){
            vector<int> curr = intervals[i];
            if(curr[0] > last[1]){
                ans.push_back(curr);
                last[0] = curr[0];
                last[1] = curr[1];
            }
            else{
                vector<int> b = ans.back();
                ans.pop_back();
                b[0] = min(b[0], curr[0]);
                b[1] = max(b[1], curr[1]);
                ans.push_back(b); 
                last[0] = b[0];
                last[1] = b[1];
            }
        }

        return ans;
    }
};
