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
    public int longestConsecutive(TreeNode root) {
        int ans[] = new int[1];

        solve(root, ans);

        return ans[0];
    }

    private void solve(TreeNode root, int ans[]){
        if(root == null){
            return;
        }

        int leftInc = consecutiveInc(root.left, ans, root.val+1);
        int leftDec = consecutiveDec(root.left, ans, root.val-1);

        int rightInc = consecutiveInc(root.right, ans, root.val+1);
        int rightDec = consecutiveDec(root.right, ans, root.val-1);

        int curr = Math.max(leftInc+rightDec+1, leftDec+rightInc+1);
        ans[0] = Math.max(ans[0], curr);

        solve(root.left, ans);
        solve(root.right, ans);
    }

    private int consecutiveInc(TreeNode node, int[] ans, int exp){
        if(node == null){
            return 0;
        }
        if(node.val != exp){
            return 0;
        }

        int leftInc = consecutiveInc(node.left, ans, node.val+1);
        int rightInc = consecutiveInc(node.right, ans, node.val+1);

        return 1+Math.max(leftInc, rightInc);
    }

    private int consecutiveDec(TreeNode node, int[] ans, int exp){
        if(node == null){
            return 0;
        }

        if(node.val != exp){
            return 0;
        }

        int left = consecutiveDec(node.left, ans, node.val-1);
        int right = consecutiveDec(node.right, ans, node.val-1);

        return 1+Math.max(left, right);
    }
}
