class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Job> jobList = new ArrayList();

        for(int i=0; i<startTime.length; i++){
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobList.add(job);
        }

        Collections.sort(jobList);

        int[] ans = new int[1];
        int prevEnd = 0;
        int curr = 0;
        solve(jobList, 0, 0, ans, 0);

        return ans[0];
        
    }

    private void solve(List<Job> jobList, int currEnd, int currProfit, int[] ans, int curr){
        if(curr == jobList.size()){
            ans[0] = Math.max(ans[0], currProfit);
            return;
        }

        // can Choose?

        if(jobList.get(curr).start >= currEnd){
            // choose
            solve(jobList, jobList.get(curr).end, currProfit+jobList.get(curr).profit,ans,curr+1);

        }

        // dont' choose
        solve(jobList, currEnd, currProfit,ans,curr+1);
    }

    class Job implements Comparable<Job>{
        int start;
        int end;
        int profit;

        Job(int s, int e, int p){
            this.start = s;
            this.end = e;
            this.profit = p;
        }

        @Override
        public int compareTo(Job j2){
            if(this.start != j2.start){
                return Integer.compare(this.start, j2.start);
            }
            return Integer.compare(this.end, j2.end);
        }
    }
}