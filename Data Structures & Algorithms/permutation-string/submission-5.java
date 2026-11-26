class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }

        int window = s1.length();

        Map<Character, Integer> s1FreqMap = new HashMap();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            int freq = s1FreqMap.getOrDefault(c,0)+1;
            s1FreqMap.put(c,freq);
        }

        Map<Character, Integer> s2WindMap = new HashMap();

        for(int i=0; i<window; i++){
            char c = s2.charAt(i);
            int freq = s2WindMap.getOrDefault(c,0) + 1;
            s2WindMap.put(c, freq);
        }

        if(isEqual(s2WindMap, s1FreqMap)){
            return true;
        }

        int l = 0;
        int r = window;

        while(r < s2.length()){
            char prev = s2.charAt(l);
            int prevFreq = s2WindMap.getOrDefault(prev,0)-1;
            if(prevFreq == 0){
                s2WindMap.remove(prev);
            }else{
                s2WindMap.put(prev, prevFreq);
            }
            char curr = s2.charAt(r);
            int currFreq = s2WindMap.getOrDefault(curr,0)+1;
            s2WindMap.put(curr, currFreq);

            if(s2WindMap.size() == s1FreqMap.size()){
                if(isEqual(s2WindMap, s1FreqMap)){
                    return true;
                }
            }
            l++;
            r++;
        }

        return false;


        
    }


    private boolean isEqual(Map<Character,Integer> s2WindMap, Map<Character,Integer> s1FreqMap){
        if(s2WindMap.size() != s1FreqMap.size()){
            return false;
        }

        for(Map.Entry<Character,Integer> entry: s2WindMap.entrySet()){
            Character c = entry.getKey();
            int val = entry.getValue();

            if(!s1FreqMap.containsKey(c) || s1FreqMap.get(c) != val){
                return false;
            }
        }

        return true;
    }
}
