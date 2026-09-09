class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Job> jobList = new ArrayList<>();
        Map<String, Integer> cache = new HashMap<>();

        for (int i = 0; i < startTime.length; i++) {
            jobList.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobList);

        return solve(jobList, 0, 0, cache);
    }

    private int solve(
        List<Job> jobList,
        int currEnd,
        int curr,
        Map<String, Integer> cache
    ) {

        String key = curr + "|" + currEnd;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (curr == jobList.size()) {
            return 0;
        }

        int ans;

        if (jobList.get(curr).start >= currEnd) {

            // Choose current job
            int choose =
                jobList.get(curr).profit +
                solve(
                    jobList,
                    jobList.get(curr).end,
                    curr + 1,
                    cache
                );

            // Don't choose current job
            int dontChoose =
                solve(
                    jobList,
                    currEnd,
                    curr + 1,
                    cache
                );

            ans = Math.max(choose, dontChoose);

        } else {

            // Cannot choose current job
            ans = solve(
                jobList,
                currEnd,
                curr + 1,
                cache
            );
        }

        cache.put(key, ans);

        return ans;
    }

    class Job implements Comparable<Job> {

        int start;
        int end;
        int profit;

        Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }

        @Override
        public int compareTo(Job j2) {
            if (this.start != j2.start) {
                return Integer.compare(this.start, j2.start);
            }

            return Integer.compare(this.end, j2.end);
        }
    }
}