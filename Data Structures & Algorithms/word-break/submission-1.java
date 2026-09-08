class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp = new boolean[n];
        
        for(int i=n-1; i>=0; i--){
            String curr = s.substring(i);
            boolean pos = false;
            for(int j=0; j<wordDict.size(); j++){
                String dict = wordDict.get(j);
                if(startsWith(dict, curr)){
                    int rem = i+dict.length();
                    if(rem >= s.length()){
                        pos = true;
                    }
                    else{
                        pos = dp[rem];
                    }
                }
                if(pos){
                    dp[i] = pos;
                    break;
                }
            }
        }

        return dp[0];
    }

    private boolean startsWith(String dict, String curr){
        if (dict.length() > curr.length()){
            return false;
        }

        for(int i=0; i<dict.length(); i++){
            if(dict.charAt(i) != curr.charAt(i)){
                return false;
            }

        }
        return true;
    }
}
