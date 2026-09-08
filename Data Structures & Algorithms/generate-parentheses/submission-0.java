class Solution {
    public List<String> generateParenthesis(int n) {

        int open = 0;
        int close = 0;

        List<String> ans = new ArrayList();

        String curr = "";

        solve(open, close, curr, ans, n);

        return ans;
        
    }

    private void solve(int open, int close, String curr, List<String> ans, int n){
        if(open == close && open == n){
            ans.add(curr);
            return;
        }

        if(open == close){
            solve(open+1, close, curr+"(", ans, n);
        } else{
            if(open < n){
                solve(open+1, close, curr+"(", ans, n);
            }
            if(close < open){
                solve(open, close+1, curr+")", ans, n);
            }
        }
    }
}
