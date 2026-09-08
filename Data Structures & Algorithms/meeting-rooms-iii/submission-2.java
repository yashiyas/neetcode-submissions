class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

        Map<Integer, Pair> rooms = new HashMap();

        int i=0;

        while(i < meetings.length){
            int start = meetings[i][0];
            int end = meetings[i][1];
            long duration = end - start;

            int bestRoom = -1;
            long earliestEnd = Long.MAX_VALUE;

            for(int j=0; j<n; j++){
                long roomEnd = rooms.containsKey(j) ? rooms.get(j).end : 0;
                if(roomEnd <= start){
                    bestRoom = j;
                    break;
                }
                if(roomEnd < earliestEnd){
                    earliestEnd = roomEnd;
                    bestRoom = j;
                }
            }

            if(rooms.containsKey(bestRoom)){
                Pair curr = rooms.get(bestRoom);
                curr.num = curr.num+1;
                curr.end = Math.max((long)start, curr.end) + duration;
            } else {
                rooms.put(bestRoom, new Pair(1, (long)start + duration));
            }
            i++;
        }

        int currMax = -1;
        int ans = 0;

        for(int j=0; j<n; j++){
            if(rooms.containsKey(j) && rooms.get(j).num > currMax){
                currMax = rooms.get(j).num;
                ans = j;
            }
        }

        return ans;
    }

    class Pair{
        int num;
        long end;

        public Pair(int n, long end){
            this.num = n;
            this.end = end;
        }
    }
}