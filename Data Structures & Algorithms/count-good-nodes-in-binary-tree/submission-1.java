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
    public int goodNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        int currMax = root.val;
        int currCount = 0;
        return 1+goodNodesCount(root.left, currMax)+goodNodesCount(root.right, currMax);
        
    }

    private int goodNodesCount(TreeNode node, int currMax){
        if(node == null){
            return 0;
        }
        if(node.val >= currMax){
            return 1+goodNodesCount(node.left, node.val)+goodNodesCount(node.right, node.val);
        }
        else{
            return goodNodesCount(node.left, currMax)+goodNodesCount(node.right, currMax);
        }
    }
}
