/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while(curr != null){
            if(curr == p || curr == q){
                return curr;
            }

            if((isPresent(curr.left, p) && isPresent(curr.right, q)) || (isPresent(curr.left, q) && isPresent(curr.right, p))){

                return curr;
            }

            if(isPresent(curr.left, p) && isPresent(curr.left, q)){
                curr = curr.left;
            }
            else if(isPresent(curr.right, p) && isPresent(curr.right, q)){
                curr = curr.right;
            }
        }

        return curr;
        
    }

    private boolean isPresent(TreeNode curr, TreeNode p){
        if(curr == null){
            return false;
        }
        
        if(curr == p){
            return true;
        }

        return isPresent(curr.left, p) || isPresent(curr.right, p);
    }
}