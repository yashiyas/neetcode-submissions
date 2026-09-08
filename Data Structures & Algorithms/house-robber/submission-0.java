class Solution {
    public int rob(int[] nums) {

        int[] choices = new int[]{0,0};


        for(int i=0; i<nums.length; i++){
            int included = nums[i]+choices[0];
            int excluded = choices[1];

            int curr = Math.max(included, excluded);

            choices[0] = choices[1];
            choices[1] = curr;
        }

        return choices[1];
        
    }
}
