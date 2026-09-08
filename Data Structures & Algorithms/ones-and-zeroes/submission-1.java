class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        Map<String,Integer> cache = new HashMap();
        return solve(strs,m,n,0,cache);
    }

    private int solve(String[] strs, int m, int n, int index, Map<String,Integer> cache){

        if(index == strs.length){
            return 0;
        }

        String key = String.valueOf(index)+"|"+String.valueOf(m)+"|"+String.valueOf(n);
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        String element = strs[index];
        int czero = 0;
        int cone = 0;

        for(int i=0; i<element.length(); i++){
            if(element.charAt(i) == '1'){
                cone++;
            }
            if(element.charAt(i) == '0'){
                czero++;
            }
        }

        int ans = solve(strs,m,n,index+1,cache);



        if(czero <= m && cone <=n){
            ans = Math.max(ans, 1+solve(strs,m-czero,n-cone,index+1,cache));
        }

        cache.put(key,ans);

        return ans;


    }
}