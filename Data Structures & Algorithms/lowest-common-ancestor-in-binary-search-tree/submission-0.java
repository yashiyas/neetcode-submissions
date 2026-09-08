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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == q.val){
            return p;
        }

        TreeNode curr = root;

        TreeNode lower = p;
        TreeNode higher = q;

        if(p.val > q.val){
            lower = q;
            higher = p;
        }

        while(true){
            if(curr.val == lower.val){
                return curr;
            }
            if(curr.val == higher.val){
                return curr;
            }
            if(lower.val < curr.val && higher.val > curr.val){
                return curr;
            }
            if(lower.val<= curr.val){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        
    }
}
