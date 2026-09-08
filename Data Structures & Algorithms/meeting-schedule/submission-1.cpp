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
    static bool myComp(Interval &I1, Interval &I2){
        return I1.end < I2.end;
    }
    bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), myComp);

        int last = INT_MIN;

        for(int i=0; i<intervals.size(); i++){
            if(intervals[i].start >= last){
                last = intervals[i].end;
            }
            else{
                return false;
            }
        }

        return true;
    }
};
