class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ans = 0;
        int k = 0;

        int currLength = 0;

        Set<Character> charSet = new HashSet();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!charSet.contains(c)){
                ans = Math.max(ans, (i-k+1));
                charSet.add(c);
            }else{
                
                while(charSet.contains(c)){
                    charSet.remove(s.charAt(k));
                    k++;
                }

                charSet.add(c);

            }

        }

        return ans;
        
    }
}
