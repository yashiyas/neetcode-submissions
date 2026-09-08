class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character, String> digitMap = getDigitMap();

        List<String> ans = new ArrayList();

        if(digits.length() == 0){
            return ans;
        }

        String curr = "";

        solve(curr,0,ans,digitMap,digits);

        return ans;
        
    }

    private void solve(String curr, int index, List<String> ans,Map<Character, String> digitMap, String digits){
        if(index == digits.length()){
            ans.add(curr);
            return;
        }

        String letters = digitMap.get(digits.charAt(index));

        for(int i=0; i<letters.length(); i++){
            // add
            curr = curr + String.valueOf(letters.charAt(i));
            solve(curr,index+1,ans,digitMap,digits);

            // remove
            curr = curr.substring(0, curr.length()-1);
        }
    }

    private Map<Character, String> getDigitMap(){
        Map<Character, String> dm = new HashMap();

        dm.put('2', "abc");
        dm.put('3', "def");
        dm.put('4', "ghi");
        dm.put('5', "jkl");
        dm.put('6', "mno");
        dm.put('7', "pqrs");
        dm.put('8', "tuv");
        dm.put('9', "wxyz");

        return dm;
    }
}
