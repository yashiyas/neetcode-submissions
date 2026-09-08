class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> unique = new HashSet();

        for(int i=0; i<nums.length; i++){
            int sum = -1*nums[i];
            findSum(i,sum,unique,nums);
        }

        List<List<Integer>> ans = new ArrayList(unique);

        return ans;

        
    }

    private void findSum(int index, int sum, Set<List<Integer>> unique, int[] nums){

        int l=0;
        int r = nums.length-1;

        while(l<r){
            if(l == index){
                l++;
                continue;
            }
            if(r == index){
                r--;
                continue;
            }

            int curr = nums[l] + nums[r];
            if(curr == sum){
                List<Integer> currAns = new ArrayList();
                currAns.add(nums[index]);
                currAns.add(nums[l]);
                currAns.add(nums[r]);
                Collections.sort(currAns);
                unique.add(currAns);

                l++;
                r--;
            }else if(curr > sum){
                r--;
            }else{
                l++;
            }

        }

    }
}
