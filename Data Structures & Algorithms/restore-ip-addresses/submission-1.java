class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        if(s.length() > 12){
            return ans;
        }

        backtrack(s,0,"",0,ans);

        return ans;
        
    }

    private void backtrack(String s, int dots, String curr, int index, List<String> ans){
        if(dots == 4 && index == s.length()){
            ans.add(curr.substring(0,curr.length() - 1));
            return;
        }

        if(dots > 4){
            return;
        }

        for(int i = index; i<Math.min(s.length(),index+3); i++){
            String substring = s.substring(index, i+1);
            if(substring.length() > 1 && substring.charAt(0) == '0'){
                continue;
            }

            if(Integer.valueOf(substring) >= 256){
                return;
            }

            backtrack(s,dots+1,curr+substring+".",i+1,ans);
        } 
    }
}