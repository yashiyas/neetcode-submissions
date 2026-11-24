class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> numMap = new HashMap();

        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++){
            int compl = target - nums[i];

            if(numMap.containsKey(compl)){
                ans[0] = numMap.get(compl);
                ans[1] = i;
                return ans;
            }

            numMap.put(nums[i], i);
        }

        return ans;

        
        
    }
}
