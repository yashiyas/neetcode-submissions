class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.val - a.val);
        int n= nums.length;
        int[] ans = new int[n-k+1];

        for(int i=0; i<k; i++){
            Pair p = new Pair(i,nums[i]);
            pq.add(p);
        }

        ans[0] = pq.peek().val;

        for(int i=k; i<n; i++){
            Pair p = new Pair(i, nums[i]);
            pq.add(p);

            while(!pq.isEmpty() && pq.peek().key < (i-k+1)){
                pq.poll();
            }
            ans[i-k+1] = pq.peek().val;
        }

        return ans;


    }

    class Pair{
        int key;
        int val;

        Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
