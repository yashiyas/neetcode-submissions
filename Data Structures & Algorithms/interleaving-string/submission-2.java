class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s3.length() != s1.length()+s2.length()){
            return false;
        }
        return solve(0,0,0,s1,s2,s3);



    }

    private boolean solve(int i, int j, int k, String s1, String s2, String s3){
        if(k == s3.length()){
            return true;
        }

        boolean ans = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
           ans = ans || solve(i+1,j,k+1,s1,s2,s3);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k) && !ans){
            ans = ans || solve(i,j+1,k+1,s1,s2,s3);
        }

        return ans;
    }
}
