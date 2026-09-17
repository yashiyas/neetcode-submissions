/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> inorder = new ArrayList();

        ArrayDeque<TreeNode> stack = new ArrayDeque();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }
        }

        int n = inorder.size();

        if(k == n){
            return inorder;
        }

        int l = 0;
        int r = k-1;

        

        while( (r< n-1)){

            double first = Math.abs(inorder.get(l) - target);
            double last = Math.abs(inorder.get(r+1) - target);

            if(first > last){
                l++;
                r++;
            }else{
                break;
            }

        }

        List<Integer> ans = new ArrayList();

        for(int i=l; i<=r; i++){
            ans.add(inorder.get(i));
        }

        return ans;


        
    }
}
