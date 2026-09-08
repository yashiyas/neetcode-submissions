class Solution {
    public String longestPalindrome(String s) {
        String ans = String.valueOf(s.charAt(0));

        int r = 0;
        int l = 0;

        //odd

        for(int i=0; i<s.length(); i++){
            l = i-1;
            r = i+1;

            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(ans.length() < r-l+1){
                    ans = s.substring(l,r+1);
                }
                l--;
                r++; 
            }
        }

        //even

        for(int i=0; i<s.length()-1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1 == c2){
                if(ans.length() < 2){
                    ans = s.substring(i,i+2);
                }
                l = i-1;
                r = i+2;

                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    if(ans.length() < r-l+1){
                    ans = s.substring(l,r+1);
                }
                    r++;
                    l--;
                }
            }
        }

        return ans;

        
    }
}