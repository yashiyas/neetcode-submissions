class Solution {
    public int missingElement(int[] nums, int k) {

        List<Integer> missed = new ArrayList();

        int prev = nums[0];

        for(int i=0; i<nums.length; i++){
            int missing = nums[i] - (nums[0]+i);
            missed.add(missing);
        }

        int index = getIndex(missed,k);

        if(missed.get(index) < k){

            return nums[index] + (k-missed.get(index));

        }else if(missed.get(index) == k){

            while(index-1 >=0 && missed.get(index) == k){
                index--;
            }

            return nums[index-1]+1;

        }else{
            return nums[index]+(k-missed.get(index));
        }



        
        
    }

    

    private int getIndex(List<Integer> missed, int target){
        int index = 0;
        
        int l = 0;
        int r = missed.size()-1;

        while(l <=r ){
            int mid = (r-l)/2 + l;

            if(missed.get(mid) < target){
                index = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return index;
    }
}
