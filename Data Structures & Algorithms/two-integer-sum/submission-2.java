class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            s.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(s.contains(diff)){
                for(int j=0; j<nums.length; j++){
                    if(nums[j] == diff && j!=i){
                        if(i<j)
                        {
                            res[0] = i;
                            res[1] = j;
                        }
                        else{
                            res[0] = j;
                            res[1] = i;
                        }
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
