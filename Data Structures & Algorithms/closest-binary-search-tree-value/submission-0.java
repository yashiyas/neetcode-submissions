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
    public int closestValue(TreeNode root, double target) {

        int ans = root.val;

        TreeNode curr = root;

        while(curr != null){
            if(Math.abs(curr.val-target) < Math.abs(ans-target)){
                ans = curr.val;
            }
            if(target > curr.val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        return ans;
        
    }
}
