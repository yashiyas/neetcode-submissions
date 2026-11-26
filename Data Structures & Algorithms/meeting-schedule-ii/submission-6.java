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

        int ans = 0;

        intervals.sort((a,b)-> a.start-b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);

        int i = 0;

        while(i < intervals.size()){
            if(pq.isEmpty()){
                pq.offer(intervals.get(i));
                i++;
            }else{
                while(!pq.isEmpty() && pq.peek().end <= intervals.get(i).start){
                    pq.poll();
                }
                pq.offer(intervals.get(i));
                i++;
            }
            ans = Math.max(ans, pq.size());
        }

        return ans;



    }
}
