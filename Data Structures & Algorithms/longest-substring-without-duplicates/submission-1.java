class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l <=1){
            return l;
        }

        int i=0;
        int j=0;
        int ans = 0;
        int curr = 0;

        Set<Character> charSet = new HashSet();

        while(j<l){
            char c = s.charAt(j);
            if(!charSet.contains(c)){
                curr = j - i+1;
                if(curr > ans){
                    ans = curr;
                }
                charSet.add(c);
                j++;
            }
            else {
                while(true){
                    if(s.charAt(i) == c){
                        i++;
                        j++;
                        break;
                    }
                    charSet.remove(s.charAt(i));
                    i++;
                }
            }
        }

        return ans;

    }
}
