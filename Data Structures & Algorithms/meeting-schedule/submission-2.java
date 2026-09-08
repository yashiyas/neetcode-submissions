/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        int size = intervals.size();
        if(size <=0){
            return true;
        }

        Collections.sort(intervals, (a,b)-> a.start - b.start);

        int i=1;
        Interval prev = intervals.get(0);

        while(i < size){
            Interval curr = intervals.get(i);

            if(curr.start < prev.end){
                return false;
            }

            prev = curr;
            i++;
        }

        return true;

    }
}
