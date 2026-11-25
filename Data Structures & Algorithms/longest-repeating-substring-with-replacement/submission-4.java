class Solution {
    public int characterReplacement(String s, int k) {

        int currMax = 0;
        int n = s.length();

        int l = 0;
        int r = 0;

        int ans = 0;

        Map<Character, Integer> charFreq = new HashMap();

        while(r < n){
            char c = s.charAt(r);
            int freq = charFreq.getOrDefault(c,0)+1;
            if(freq > currMax){
                currMax = freq;
            }

            charFreq.put(c, freq);

            while((r-l+1) - currMax > k){
                int lfreq = charFreq.get(s.charAt(l)) - 1;
                if(lfreq == 0){
                    charFreq.remove(s.charAt(l));
                }else{
                    charFreq.put(s.charAt(l), lfreq);
                }
                l++;
            }

            if(r-l+1 > ans){
                ans = r-l+1;
            }

            r++;

        }

        return ans;
        
    }
}
