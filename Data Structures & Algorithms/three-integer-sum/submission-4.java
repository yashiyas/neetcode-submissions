class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList();

        Set<List<Integer>> unique = new HashSet();

        for(int i=0; i<n; i++){
            int curr = -1* nums[i];
            getTwoSum(curr,i,nums, unique);
        }

        for(List<Integer> valid: unique){
            ans.add(valid);
        }

        return ans;
        
    }

    void getTwoSum(int sum, int index, int[] nums, Set<List<Integer>> unique){
        int l = index + 1;
        int r = nums.length - 1;

        while(l<r){
            int curr = nums[l]+nums[r];

            if(curr == sum){
                List<Integer> ans = new ArrayList();
                ans.add(nums[index]);
                ans.add(nums[l]);
                ans.add(nums[r]);
                Collections.sort(ans);
                unique.add(ans);
                l++;
                r--;
            } else if (curr < sum){
                l++;
            }else{
                r--;
            }
        }
    }
}