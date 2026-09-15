class Solution {
    public boolean verifyPreorder(int[] preorder) {

        int lower = Integer.MIN_VALUE;
        

        ArrayDeque<Integer> stack = new ArrayDeque();

        stack.push(preorder[0]);

        int i=1;

        while(i < preorder.length){
            int curr = preorder[i];
            if(curr < lower){
                return false;
            }
            if(stack.isEmpty()){
                stack.push(curr);
                i++;
            }else{
                if(stack.peek() > preorder[i]){
                    stack.push(curr);
                    i++;
                }else{
                    lower = stack.pop();
                }
                
            }
            
        }

        return true;
        
    }
}
