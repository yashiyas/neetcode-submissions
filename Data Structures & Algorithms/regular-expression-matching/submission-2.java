class Solution {
    public boolean isMatch(String s, String p) {
        Map<String,Boolean> cache = new HashMap();
        return solve(s,p,0,0,cache);
    }

    private boolean solve(String s, String p, int s1, int p1, Map<String,Boolean> cache){
        if(p1 == p.length()){
            return s1 == s.length();
        }

        String key = String.valueOf(s1)+"|"+String.valueOf(p1);
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        boolean firstMatch = (s1 < s.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.'));

        if(p1 + 1 < p.length() && p.charAt(p1 + 1) == '*'){
            boolean res =  solve(s, p, s1, p1 + 2,cache) || (firstMatch && solve(s, p, s1 + 1, p1,cache));
            cache.put(key,res);
            return res;
        }

        if(firstMatch){
            boolean res =  solve(s, p, s1 + 1, p1 + 1,cache);
            cache.put(key,res);
            return res;
        }
        cache.put(key,false);
        return false;
    }
}