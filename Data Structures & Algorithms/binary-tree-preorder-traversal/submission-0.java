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
    public List<Integer> preorderTraversal(TreeNode root) {

        TreeNode curr = root;

        ArrayDeque<TreeNode> aq = new ArrayDeque();

        List<Integer> ans = new ArrayList();

        while(!aq.isEmpty() || curr != null){
            if(curr != null){
                ans.add(curr.val);
                aq.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode top = aq.pop();
                curr = top.right;
            }
        }

        return ans;
        
    }
}