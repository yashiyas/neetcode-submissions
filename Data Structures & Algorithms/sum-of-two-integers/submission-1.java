class Solution {
    public int getSum(int a, int b) {

        int res = a^b;
        int carry = (a&b) << 1;

        while (carry != 0){
            int temp = (res & carry) << 1;
            res = res ^ carry;
            carry = temp; 
        }

        return res;
        
    }
}