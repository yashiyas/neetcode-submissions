class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.minHeap = new PriorityQueue();
        this.k = k;

        for(int i=0; i<nums.length; i++){
            minHeap.offer(nums[i]);
        }

        while(minHeap.size() > k){
            minHeap.poll();
        }
        
    }
    
    public int add(int val) {

        if(minHeap.size() == k){
            if(val < minHeap.peek()){
                return minHeap.peek();
            }
            else{
                minHeap.poll();
                minHeap.offer(val);
                return minHeap.peek();
            }
        } else{
            minHeap.offer(val);
            return minHeap.peek();
        }
        
    }
}
