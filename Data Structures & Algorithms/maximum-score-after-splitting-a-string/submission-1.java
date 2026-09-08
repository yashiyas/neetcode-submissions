class Solution {
    public int maxScore(String s) {

        int n = s.length();

        int totalOnes = 0;
        int totalZeros = 0;

        int[] ones = new int[n];
        int[] zeros = new int[n];

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                totalOnes++;
                ones[i] = (i-1 >=0) ? ones[i-1]+1: 1;
                zeros[i] = (i-1 >=0) ? zeros[i-1]: 0;
            }else{
                totalZeros++;
                ones[i] = (i-1 >=0) ? ones[i-1]: 0;
                zeros[i] = (i-1 >=0) ? zeros[i-1]+1: 1;
            }
        }

        int ans = 0;

        for(int i=0; i<n-1; i++){
            int curr = zeros[i]+(totalOnes-ones[i]);
            if(curr > ans){
                ans = curr;
            }
        }

        return ans;


        
    }
}