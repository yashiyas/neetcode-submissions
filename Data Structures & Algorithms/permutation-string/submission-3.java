class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> s1Freq = new HashMap();

        for(int i=0; i<s1.length(); i++){
            Character ch = s1.charAt(i);
            int freq = s1Freq.getOrDefault(ch,0)+1;
            s1Freq.put(ch, freq);
        }

        Map<Character, Integer> s2Freq = new HashMap();

        int l=0;
        int r=0;

        while(l<=r && r < s2.length()){
            Character ch = s2.charAt(r);
            if(s1Freq.containsKey(ch)){
                int currFreq = s2Freq.getOrDefault(ch, 0);
                if(currFreq < s1Freq.get(ch)){
                    s2Freq.put(ch, currFreq+1);
                    int len = r-l+1;
                    if(len == s1.length()){
                        return true;
                    }
                    r++;
                }else{
                    while(s2.charAt(l) != ch){
                        if(s2Freq.containsKey(s2.charAt(l))){
                            int freq = s2Freq.get(s2.charAt(l))-1;
                            if(freq == 0){
                                s2Freq.remove(s2.charAt(l));
                            }else{
                                s2Freq.put(s2.charAt(l), freq);
                            }
                        }
                        l++;
                    }
                    l++;
                    r++;
                }
            }else{
                r++;
                l=r;
                s2Freq = new HashMap();
            }
        }

        return false;

        
    }
}
