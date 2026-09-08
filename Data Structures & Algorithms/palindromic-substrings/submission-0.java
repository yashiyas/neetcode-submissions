class Solution {
    public int countSubstrings(String s) {

        int ans = s.length();
        
        // count odd

        for(int i=0; i<s.length(); i++){
            int r = i+1;
            int l = i-1;

            while(l>=0 && r<s.length() && s.charAt(r) == s.charAt(l)){
                r++;
                l--;
                ans++;
            }
        }

        // count even

        for(int i=0; i<s.length()-1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);

            if(c1==c2){
                int r = i+2;
                int l = i-1;
                ans++;

                while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                    ans++;
                }
            }
        }

        return ans;


        
    }
}
