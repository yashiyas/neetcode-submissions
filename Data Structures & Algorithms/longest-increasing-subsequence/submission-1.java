class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        Pair[] dp = new Pair[n];

        int ans = 1;

        dp[n-1] = new Pair(nums[n-1],1);

        for(int i=n-2; i>=0; i--){
            int curr = nums[i];
            int j=i+1;
            Pair c = new Pair(curr,1);
            while(j<n){
                Pair p = dp[j];
                if(p.minNumber > curr){
                    c.size = Math.max(c.size,1+p.size);
                    ans = Math.max(ans,c.size);
                }
                j++;
            }
            dp[i] = c;
        }

        return ans;

        
    }

    class Pair{
        int minNumber;
        int size;

        Pair(int n, int s){
            this.minNumber = n;
            this.size = s;
        }
    }
}
