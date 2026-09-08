class Solution {
    public int[][] merge(int[][] intervals) {

       Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> ans = new ArrayList();

        ans.add(intervals[0]);

        int i=1;
        int index=0;

        while(i<intervals.length){
            int[] prevInterval = ans.get(index);
            int[] currInterval = intervals[i];

            if( currInterval[0] <= prevInterval[1] || currInterval[0] == prevInterval[0] || currInterval[1] == prevInterval[1]){
                prevInterval[0] = Math.min(prevInterval[0], currInterval[0]);
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else{
                ans.add(currInterval);
                index++;
            }
            i++;
        }

        return ans.toArray(new int[ans.size()][2]);
        
    }
}
