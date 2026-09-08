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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() <=1){
            return intervals.size();
        }

        Collections.sort(intervals, (a,b)->a.start - b.start);

        List<Integer> rooms = new ArrayList();

        int i=0;

        while(i<intervals.size()){
            Interval curr = intervals.get(i);
            if(rooms.isEmpty()){
                rooms.add(curr.end);
            }else{
                boolean nonOverlapping = false;
                for(int j=0; j<rooms.size(); j++){
                    if(curr.start >= rooms.get(j)){
                        nonOverlapping = true;
                        rooms.set(j,curr.end);
                        break;
                    }
                }
                if(!nonOverlapping){
                    rooms.add(curr.end);
                }
            }
            i++;

        }

        return rooms.size();


    }

}
