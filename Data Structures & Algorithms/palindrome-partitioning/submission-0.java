class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList();

        List<String> curr = new ArrayList();

        solve(s,ans,curr,0);

        return ans;
        
    }

    private void solve(String s, List<List<String>> ans, List<String> curr, int index){
        if(index == s.length()){
            List<String> temp = new ArrayList<>(curr);
            ans.add(temp);
            return;
        }

        String word = "";
        for(int i=index; i<s.length(); i++){
            word = word + String.valueOf(s.charAt(i));
            if(isPalindrome(word)){
                curr.add(word);
                solve(s,ans,curr,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String word){
        if(word.length() == 1){
            return true;
        }

        int i=0;
        int j=word.length()-1;

        while(i<j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
