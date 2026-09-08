class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> charMap = new HashMap();
        int l = s.length();
        int i=0;
        int j=0;
        int maxFreq = 0;
        int maxWindow = 0;
        while(j<l){
            char c = s.charAt(j);
            if(charMap.containsKey(c)){
                int freq = charMap.get(c)+1;
                charMap.put(c, freq);
            }
            else{
                charMap.put(c, 1);
            }
            maxFreq = findMaxFreq(charMap);
            if((j-i+1 - maxFreq) <= k ){
                maxWindow = Math.max(maxWindow, j-i+1);
                j++;
            }
            else{
                while((j-i+1 - maxFreq ) > k)
                {
                    int newFreq = charMap.get(s.charAt(i)) -1;
                    charMap.put(s.charAt(i), newFreq);
                    if(newFreq == 0){
                        charMap.remove(s.charAt(i));
                    }
                    i++;
                    maxFreq = findMaxFreq(charMap);
                }
                j++;

            }
        }
        return maxWindow;
    }

    private int findMaxFreq(Map<Character,Integer> charMap){
        int ans=0;
        for(Map.Entry<Character,Integer> c: charMap.entrySet()){
            if(ans < c.getValue()){
                ans=c.getValue();
            }
        }
        return ans;
    }
}
