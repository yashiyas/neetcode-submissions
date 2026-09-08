class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        Set<Integer> numSet = new HashSet();

        for(int i: nums){
            numSet.add(i);
        }

        int ans = 1;

        for(int i=0; i<nums.length; i++){
            if(!numSet.contains(nums[i] - 1)){
                int length = 1;
                while(numSet.contains(nums[i]+length)){
                    length++;
                    if(ans < length){
                        ans = length;
                    }
                }
            }
        }

        return ans;
        
    }
}
