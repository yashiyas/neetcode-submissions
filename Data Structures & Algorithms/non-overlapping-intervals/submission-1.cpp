class Solution {
public:
    static bool myComp(vector<int> &v1, vector<int> &v2){
        return v1[0] < v2[0];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int ans = 0;
        int n = intervals.size();
        sort(intervals.begin(), intervals.end(), myComp);
        int last = intervals[0][1];
        for(int i=1; i<n; i++){
            vector<int> curr = intervals[i];
            int s = curr[0];
            int e = curr[1];
            cout << s <<" "<<e<<"\n";
            if(curr[0] < last){
                cout<< "last "<<last<<"\n";
                ans++;
                last = min(last,curr[1]);
            }
            else{
                last = curr[1];
            }
        }

        return ans;
    }
};
