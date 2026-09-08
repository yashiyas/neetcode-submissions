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
    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return root;
        }

        Queue<TreeNode> aq = new LinkedList();
        aq.offer(root);

        while(!aq.isEmpty()){
            TreeNode curr = aq.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left != null){
                aq.offer(curr.left);
            }

            if(curr.right != null){
                aq.offer(curr.right);
            }
        }

        return root;
        
    }
}
