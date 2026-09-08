class Solution {
    public int findDuplicate(int[] nums) {

        int s = nums[0];
        int f = nums[0];

        while(true){
            s = nums[s];
            f = nums[nums[f]];

            if(s==f){
                break;
            }
        }

        s = nums[0];

        while(s != f){
            s = nums[s];
            f = nums[f];
        }


        return s;



        
        
    }

}
