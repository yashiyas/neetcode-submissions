class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] ways = new int[n];
        
        Arrays.fill(ways,-1);

        if(s.charAt(n-1) == '0'){
            ways[n-1] = 0;
        }else{
            ways[n-1] = 1;
        }

        for(int i=n-2; i>=0; i--){
            char c = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c == '0'){
                ways[i] = 0;
                continue;
            }
            if( c =='1' || (c == '2' && c2 <= '6')){
                if(i+2 < n){
                    ways[i] = ways[i+2]+ways[i+1];
                }else{
                    ways[i] = 1+ways[i+1];
                }
            }
            else{
                ways[i] = ways[i+1];
            }
        }

        return ways[0];

    }

    
}
