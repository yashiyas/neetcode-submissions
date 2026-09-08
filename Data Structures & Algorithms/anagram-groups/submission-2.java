class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int s = strs.length;
        boolean [] checked = new boolean[s];
        List<List<String>> ans = new ArrayList();
        int i=0;

        while(i < s){
            if(checked[i]){
                i++;
                continue;
            }
            List<String> curr = new ArrayList();
            curr.add(strs[i]);
            checked[i] = true;
            for(int j=i+1; j<s; j++){
                if(checked[j]){
                    continue;
                }
                if(isAnagram(strs[i], strs[j])){
                    checked[j] = true;
                    curr.add(strs[j]);
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    private boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            int freq = s1Map.getOrDefault(c,0)+1;
            s1Map.put(c, freq);
        }

        for(int i=0; i<s2.length(); i++){
            char c = s2.charAt(i);
            if(!s1Map.containsKey(c)){
                return false;
            }
            int freq = s1Map.get(c) - 1;
            if(freq == 0){
                s1Map.remove(c);
            }else{
                s1Map.put(c,freq);
            }
        }

        if(s1Map.size() == 0){
            return true;
        }
        return false;
    }
}
