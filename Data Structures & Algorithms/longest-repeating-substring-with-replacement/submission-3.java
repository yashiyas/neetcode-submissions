class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;
        int r = 0;

        Map<Character,Integer> charFreqMap = new HashMap();

        int currMax = 0;
        int ans = 0;

        while(r<s.length()){
            char currChar = s.charAt(r);
            int freq = charFreqMap.getOrDefault(currChar,0)+1;
            if(freq > currMax){
                currMax = freq;
            }
            charFreqMap.put(currChar, freq);
            int windLen = r-l+1;

            if(windLen-currMax <= k){
                // valid window
                r++;
                ans = Math.max(ans,windLen);
                
            }else{
                // shrink window till valid

                while(windLen-currMax > k){
                    char charRemove = s.charAt(l);
                    int newFreq = charFreqMap.get(charRemove)-1;
                    charFreqMap.put(charRemove, newFreq);
                    currMax = getMaxFreq(charFreqMap);
                    l++;
                    windLen = r-l+1;
                }
                r++;
            }
        }

        return ans;
        
    }

    private int getMaxFreq(Map<Character,Integer> charFreqMap){
        int ans = 0;

        for(Map.Entry<Character,Integer> entry: charFreqMap.entrySet()){
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }
}
