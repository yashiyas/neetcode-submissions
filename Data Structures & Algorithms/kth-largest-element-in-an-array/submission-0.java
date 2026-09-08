class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i=0; i<nums.length; i++){
            if(pq.size() < k){
                pq.offer(nums[i]);
            } else{
                if(pq.peek() < nums[i]){
                    pq.offer(nums[i]);
                    pq.poll();
                }
            }
        }

        return pq.peek();
        
    }
}
