class Solution {
    public int countPalindromicSubsequence(String s) {

        Map<Character,Pair> charPos = new HashMap();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(charPos.containsKey(c)){
                charPos.get(c).last = i;
            }else{
                charPos.put(c, new Pair(i,i));
            }
        }

        int ans = 0;

        for(Map.Entry<Character,Pair> entry: charPos.entrySet()){
            Pair curr = entry.getValue();
            if(curr.first != curr.last){
                ans = ans + getPalindromes(curr,s);
            }
        }

        return ans;
        
    }

    private int getPalindromes(Pair curr, String s){
        if(curr.last - curr.first + 1 == 3){
            return 1;
        }

        Set<Character> uni = new HashSet();

        for(int i = curr.first+1; i<curr.last; i++){
            uni.add(s.charAt(i));
        }

        return uni.size();
    }

    class Pair{
        int first;
        int last;

        Pair(int f, int l){
            this.first = f;
            this.last = l;
        }
    }
}
    