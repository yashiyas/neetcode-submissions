class Solution {
    public int arrangeCoins(int n) {

        int total = n;
        int i =1;

        while(true){

            if(total - i < 0){
                return i-1;
            }
            else{
                total = total-i;
            }
            i++;

        }

            
            
    
        
    }
}