class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int ans = 1;

        int i=0;
        int j=0;

        PriorityQueue<int[]> pqMin = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pqMax = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] curr = new int[]{nums[0],0};
        pqMin.offer(curr);
        pqMax.offer(curr);


        while(i<=j && j<n){
            int[] currElement = new int[]{nums[j],j};
            pqMin.offer(currElement);
            pqMax.offer(currElement);
            int currMin = getCurrTop(pqMin, i);
            int currMax = getCurrTop(pqMax, i);
            int currWindow = j-i+1;
            int diff = Math.abs(currMax - currMin);

            if(diff <= limit){
                if(currWindow > ans){
                    ans = currWindow;
                }
                j++;

            }else{
                i++;
            }
        }

        return ans;

        
    }

    private int getCurrTop(PriorityQueue<int[]> pq, int index){
        int[] curr = pq.peek();
        while(curr[1] < index){
            pq.poll();
            curr = pq.peek();
        }

        return curr[0];
    }
    
}