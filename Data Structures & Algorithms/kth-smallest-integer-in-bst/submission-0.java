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
    public int kthSmallest(TreeNode root, int k) {

        ArrayDeque<TreeNode> aq = new ArrayDeque();

        TreeNode curr = root;
        int num = 0;

        while(curr != null || !aq.isEmpty()){
            if(curr != null){
                aq.push(curr);
                curr = curr.left;
            }else{
                TreeNode top = aq.pop();
                num++;
                if(num == k){
                    return top.val;
                }
                curr = top.right;
            }
        }

        return -1;
        
    }
}
