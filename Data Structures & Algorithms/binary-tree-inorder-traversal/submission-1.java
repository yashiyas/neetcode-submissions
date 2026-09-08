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
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayDeque<TreeNode> aq = new ArrayDeque();
        TreeNode curr = root;

        List<Integer> ans = new ArrayList();


        while(!aq.isEmpty() || curr != null){
            if(curr != null){
                aq.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode top = aq.pop();
                ans.add(top.val);
                curr = top.right;
            }
            
        }

        return ans;

    }
}