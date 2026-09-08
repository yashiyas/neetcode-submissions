class Solution {
    public boolean checkValidString(String s) {

        int open = 0;
        int close = 0;

        String curr = "";

        int maxP = 0;
        int minP = 0;

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);

            if(c == '('){
                maxP++;
                minP++;
            }

            if(c == ')'){
                maxP--;
                minP--;
                if(maxP < 0){
                    return false;
                }
                minP = Math.max(0,minP);
            }

            if(c == '*'){
                minP = Math.max(0,minP-1);
                maxP++;
            }
        }

        return 0>=minP && 0<=maxP;
        
    }

    


}
