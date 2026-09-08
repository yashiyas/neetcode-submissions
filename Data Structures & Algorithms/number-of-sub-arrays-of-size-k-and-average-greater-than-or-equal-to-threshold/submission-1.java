class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans =0;
        double gsum = 0;
        int n = arr.length;
        for(int i=0; i< k; i++){
            gsum+=arr[i];
        }
        double avg = gsum/k;
        if(avg>=threshold){
            ans++;
        }
        int l = 1;
        int r = k;

        while(r<n){
            gsum = gsum - arr[l-1] + arr[r];
            avg = gsum/k;
            if(avg >= threshold){
                ans++;
            }
            l++;
            r++;
        }

        return ans;
    }
}