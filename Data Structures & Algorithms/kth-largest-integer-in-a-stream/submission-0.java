class KthLargest {

    List<Integer> minHeap;
    int size;

    public KthLargest(int k, int[] nums) {
        this.size = k+1;
        this.minHeap = new ArrayList();
        Arrays.sort(nums);
        minHeap.add(-1);

        if(nums.length+1 > size){
            int start = nums.length-size+1;
            for(int i=start; i<nums.length; i++){
                minHeap.add(nums[i]);
            }
        }
        else {
            for(int i=0; i<nums.length; i++){
                minHeap.add(nums[i]);
            }

        }
    }
    
    public int add(int val) {
        if(minHeap.size() == size){
            if(val < minHeap.get(1)){
                return minHeap.get(1);
            }
            else{
                pop();
                minHeap.add(val);
                reorganise();
            }
        }
        else{
            minHeap.add(val);
            reorganise();
        }
        return minHeap.get(1);
    }

    void reorganise(){
        int s = minHeap.size() - 1;
        int parent = s/2;

        while( s>=1 && parent >=1 && minHeap.get(s) < minHeap.get(parent)){
            int temp = minHeap.get(parent);
            minHeap.set(parent, minHeap.get(s));
            minHeap.set(s, temp);
            s = parent;
            parent = s/2;
        }
    }

    void pop(){
        int s = minHeap.size() - 1;
        int last = minHeap.get(s);
        minHeap.set(1, last);
        minHeap.remove(s);

        int i = 1;
        int left = 2*i;
        int right = 2*i+1;
        s = minHeap.size()-1;

        while((left <= s && minHeap.get(i) > minHeap.get(left)) || (right <=s && minHeap.get(i) > minHeap.get(right))){
            if( left<=s && right <=s && minHeap.get(i) > minHeap.get(left) && minHeap.get(i) > minHeap.get(right)){
                if(minHeap.get(left) < minHeap.get(right)){
                    int temp = minHeap.get(i);
                    minHeap.set(i,minHeap.get(left));
                    minHeap.set(left, temp);
                    i = left;
                    left = 2*i;
                    right = 2*i+1;
                }
                else{
                    int temp = minHeap.get(i);
                    minHeap.set(i,minHeap.get(right));
                    minHeap.set(right, temp);
                    i = right;
                    left = 2*i;
                    right = 2*i+1;
                }
            }
            else if(left <= s && minHeap.get(i) > minHeap.get(left)){
                 int temp = minHeap.get(i);
                    minHeap.set(i,minHeap.get(left));
                    minHeap.set(left, temp);
                    i = left;
                    left = 2*i;
                    right = 2*i+1;
            }
            else{
                 int temp = minHeap.get(i);
                    minHeap.set(i,minHeap.get(right));
                    minHeap.set(right, temp);
                    i = right;
                    left = 2*i;
                    right = 2*i+1;
            }
        }

    }
}
