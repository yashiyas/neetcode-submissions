class Solution {
    public int[] minOperations(String boxes) {

        int n = boxes.length();

        int currOnes = 0;

        int[] rsum = new int[n];
        int[] lsum = new int[n];

        int prevSteps = 0;

        for(int i=n-1; i>=0; i--){
            rsum[i] = prevSteps + currOnes;
            prevSteps = rsum[i];
            if(boxes.charAt(i) == '1'){
                currOnes++;
            }
        }

        currOnes = 0;
        prevSteps = 0;

        for(int i=0; i<n; i++){
            lsum[i] = prevSteps + currOnes;
            prevSteps = lsum[i];
            if(boxes.charAt(i) == '1'){
                currOnes++;
            }
        }

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = rsum[i]+lsum[i];
        }

        return ans;




        
    }
}