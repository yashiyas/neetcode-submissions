class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
         if(nums.size() <= 1){
            return nums.size();
        }

        int x = nums[0]; //1
        int a = 1;
        for(int i=1; i<nums.size(); i++){
           if(nums[i] == x){
            continue;
           }
           nums[a] = nums[i];
           x=nums[i];
           a++;     
        }
        return a;
    }
};