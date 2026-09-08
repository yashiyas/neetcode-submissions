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

        PriorityQueue<Integer> pq = new PriorityQueue();

        int i=0;

        while(i<intervals.size()){
            Interval curr = intervals.get(i);
            if(pq.isEmpty()){
                pq.offer(curr.end);
            }else{
                Integer minEnd = pq.peek();
                if(minEnd <= curr.start){
                    pq.poll();
                    pq.offer(curr.end);
                }else{
                    pq.offer(curr.end);
                }
            }
            i++;

        }

        return pq.size();


    }

}
