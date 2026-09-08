/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
    
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<int> start;
        vector<int> end;
        int n = intervals.size();

        for(int i=0; i<n; i++){
            Interval I = intervals[i];
            start.push_back(I.start);
            end.push_back(I.end);
        }

        int count = 0;
        int mcount = 0;
        sort(start.begin(), start.end());
        sort(end.begin(), end.end());

        int i=0;
        int j=0;

        while(i < n){
            int s = start[i];
            int e = end[j];
            if(s < e){
                count++;
                mcount = max(mcount, count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }

        return mcount;
    }
};
