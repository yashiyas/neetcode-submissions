class Solution {
    public int numDistinct(String s, String t) {

        int i=0;
        int n = s.length();

        Map<String,Integer> cache = new HashMap();

        while(i<n && s.charAt(i) != t.charAt(0)){
            i++;
        }

        if(i >= n){
            return 0;
        }

        return count(s,t,i+1,1,cache) + count(s,t,i+1,0,cache);
        
    }

    private int count(String s, String t, int s1, int t1, Map<String,Integer> cache){
        if(t1>=t.length()){
            return 1;
        }
        if(s1 >= s.length()){
            return 0;
        }

        String key = String.valueOf(s1)+"|"+String.valueOf(t1);

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        while(s1 < s.length() && s.charAt(s1) != t.charAt(t1)){
            s1++;
        }

        if(s1 == s.length()){
            return 0;
        }

        int ans = count(s,t,s1+1,t1+1,cache)+count(s,t,s1+1,t1,cache);
        cache.put(key, ans);
        return ans;
    }
}
