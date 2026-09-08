class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftP = new int[n];
        int[] rightP = new int[n];
        int[] ans = new int[n];

        int prevL = 1;
        int prevR = 1;

        for(int i=0; i<n; i++){
            leftP[i] = prevL*nums[i];
            prevL = leftP[i];
        }

        for(int i=n-1; i>=0; i--){
            rightP[i] = prevR*nums[i];
            prevR = rightP[i];
        }

        ans[0] = rightP[1];
        ans[n-1] = leftP[n-2];

        for(int i=1; i<n-1; i++){
            ans[i] = rightP[i+1]*leftP[i-1];
        }

        return ans;

        
    }
}  
