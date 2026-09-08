class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> count = new HashMap();
        int n = nums.length;



        int thres = n/2;

        for(int i: nums){
            int freq = count.getOrDefault(i,0) + 1;
            if(freq > thres){
                return i;
            }
            count.put(i,freq);

        }

        return -1;
        
    }
}