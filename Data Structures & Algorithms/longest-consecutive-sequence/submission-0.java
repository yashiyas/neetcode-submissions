class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer,Boolean> checked = new HashMap();
        Set<Integer> numSet = new HashSet();

        for(int i:nums){
            checked.put(i,false);
            numSet.add(i);
        }

        int ans=0;

        for(int i=0; i<nums.length; i++){
            int currMin=nums[i];
            int currMax = nums[i]; 
            int currWindow = 0;
            while(numSet.contains(currMax)){
                currWindow = currMax-currMin+1;
                if(currWindow > ans){
                    ans = currWindow;
                }
                currMax++;
            }
        }

        return ans;


    }
}
