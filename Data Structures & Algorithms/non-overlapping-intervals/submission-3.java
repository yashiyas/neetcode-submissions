class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int ans = 0;
        int[] prev = intervals[0];

        int i=1;

        while(i<intervals.length){
            int[] curr = intervals[i];

            if(curr[0] < prev[1]){
                ans++;
                if(prev[1] > curr[1]){
                    prev = curr;
                }
            } else{
                prev = curr;
            }
            i++;
        }

        return ans;
        
    }
}
