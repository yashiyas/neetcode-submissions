class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int ans = 0;

        String prev = "";
        String curr = "";

        int i=0;
        int j=0;

        int currWindow = 0;

        while(j<arr.length){
            if(i==j){
                currWindow = 1;
                prev = "";
                curr = "";
                j++;
                if(currWindow > ans){
                    ans = currWindow;
                }
            }else{
                int currDiff = arr[j-1]-arr[j];
                curr = getSign(currDiff);
                if(isTurbulent(curr, prev)){
                    currWindow = j-i+1;
                    if(ans < currWindow){
                        ans = currWindow;
                    }
                    prev = curr;
                    j++;
                } else {
                    i++;
                    j=i;
                    currWindow = 1;
                    prev = "";
                }
            }
        }

        return ans;

    }

    private boolean isTurbulent(String curr, String prev){
        if(prev == "" && curr != "="){
            return true;
        }
        if(prev == ">" && curr == "<"){
            return true;
        }
        if(prev == "<" && curr == ">"){
            return true;
        }
        return false;
    }

    private String getSign(int currDiff){
        if(currDiff == 0){
            return "=";
        }
        if(currDiff > 0){
            return ">";
        }
        return "<";
    }
}