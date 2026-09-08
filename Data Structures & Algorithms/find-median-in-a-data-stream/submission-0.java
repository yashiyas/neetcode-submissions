class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
        this.minHeap = new PriorityQueue();
        
    }
    
    public void addNum(int num) {

        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());

       }
        
    }
    
    public double findMedian() {
        int m1 = maxHeap.size();
        int m2 = minHeap.size();

        int total = m1+m2;

        if(total % 2 == 0){
            int num1 = maxHeap.peek();
            int num2 = minHeap.peek();
            return ((double)(num1+num2)) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
