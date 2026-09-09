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

        TreeNode curr = root;

        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while(true){
            if(curr.val == p.val || curr.val == q.val){
                return curr;
            }

            if(p.val > curr.val){
                curr = curr.right;
            }else if(q.val < curr.val){
                curr = curr.left;
            }else{
                return curr;
            }
         
        }
        
    }
}
