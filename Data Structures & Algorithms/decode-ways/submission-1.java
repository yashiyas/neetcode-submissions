class Solution {
    public int numDecodings(String s) {

        Map<String,Integer> cache = new HashMap();

        if(s.length() == 0){
            return 0;
        }

        if(s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        // taking 1 
        int one = ways(s.substring(1,n),cache);
        int two = 0;

        if(s.length() >=2 && Integer.valueOf(s.substring(0,2)) <= 26){
            two = ways(s.substring(2,n),cache);
        }
        return one+two;

    }

    private int ways(String s, Map<String,Integer> cache){

        if(s.length() == 0){
            return 1;
        }

        if(s.charAt(0) == '0'){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        if(cache.containsKey(s)){
            return cache.get(s);
        }

        int n = s.length();

        int one = ways(s.substring(1,n),cache);
        int two = 0;

        if(s.length() >=2 && Integer.valueOf(s.substring(0,2)) <= 26){
            two = ways(s.substring(2,n),cache);
        }
        int ans =  one+two;
        cache.put(s,ans);
        return ans;

    }
}
