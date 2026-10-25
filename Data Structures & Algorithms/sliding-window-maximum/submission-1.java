class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue();

        int r = 0;
        int l = 0;

        while(pq.size() != k){
            pq.offer(new Pair(nums[r], r));
            r++;
        }

        ans[l] = pq.peek().val;
        l++;

        while(r < n){
            int curr = nums[r];

            int currMax = pq.peek().val;

            if(curr >= currMax){
                pq.offer(new Pair(nums[r], r));
                r++;
                ans[l] = curr;
                l++;
            }else{
                while(!pq.isEmpty() && pq.peek().index < (r-k+1)){
                    pq.poll();
                }
                pq.offer(new Pair(nums[r], r));
                ans[l] = pq.peek().val;
                r++;
                l++;
            }
        }

        return ans;

        
    }

    class Pair implements Comparable<Pair>{
        int val;
        int index;

        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.val-this.val;
        }


    }
}
