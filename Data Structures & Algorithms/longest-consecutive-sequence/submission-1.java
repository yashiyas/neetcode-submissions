class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numbers = new HashSet();

        for(int n: nums){
            numbers.add(n);
        }

        int ans = 0;


        for(int i=0; i<nums.length; i++){

            if(!numbers.contains(nums[i]-1)){
                int length = 1;
                while(numbers.contains(nums[i]+length)){
                    length++;
                }
                ans = Math.max(ans,length);
            }

        }

        return ans;
        
    }
}
