class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefix = new int[n];
        int [] postfix = new int[n];

        int [] ans = new int[n];

        for(int i=0; i<n; i++){
            if(i==0){
                prefix[i] = 1;
            }
            else{
                prefix[i] = prefix[i-1]*nums[i-1];
            }
        }

        for(int i=n-1; i>=0; i--){
            if(i==n-1){
                postfix[i] = 1;
            }
            else{
                postfix[i] = postfix[i+1]*nums[i+1];
            }
        }

        for(int i=0; i<n; i++){
            ans[i] = prefix[i]*postfix[i];
        }

        return ans;
        
    }
}  
