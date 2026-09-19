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
    int ans = 1;
    public int longestConsecutive(TreeNode root) {
        int[] curr = getConsecutiveLength(root);
        return ans;
    }

    private int[] getConsecutiveLength(TreeNode node){
        int[] curr = new int[2];
        if(node == null){
            return new int[]{0,0}; 
        }

        if(node.left == null && node.right == null){
            return new int[] {1,1};
        }

        int[] nextL = getConsecutiveLength(node.left);
        int[] nextR = getConsecutiveLength(node.right);

        int currMax = 0;
        int currMin = 0;

        if(node.left != null && node.left.val == node.val+1){
            // increasing
            currMax = Math.max(currMax, nextL[0]);

        }else if(node.left != null && node.left.val == node.val-1){
            // dec
            currMin = Math.max(currMin, nextL[1]);
        }

        if(node.right != null && node.right.val == node.val+1){
            // increasing
            currMax = Math.max(currMax, nextR[0]);

        }else if(node.right != null && node.right.val == node.val-1){
            // dec
            currMin = Math.max(currMin, nextR[1]);
        }

        int conse = 1+currMax+currMin;

        ans = Math.max(ans, 1+currMax);
        ans = Math.max(ans, 1+currMin);
        ans = Math.max(ans, conse);

        curr[0] = 1+currMax;
        curr[1] = 1+currMin;

        return curr;


    }
}
