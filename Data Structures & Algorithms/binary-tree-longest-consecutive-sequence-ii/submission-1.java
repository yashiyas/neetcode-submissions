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
        Map<TreeNode, Integer> inr = new HashMap();
        Map<TreeNode, Integer> dec = new HashMap();
        Map<TreeNode, Integer> rightInr = new HashMap();
        Map<TreeNode, Integer> rightDec = new HashMap();

        int ans[] = new int[1];

        solve(root, ans, inr, rightInr, dec, rightDec);

        return ans[0];
    }

    private void solve(TreeNode root, int ans[], Map<TreeNode, Integer> inr, Map<TreeNode, Integer> rightInr, Map<TreeNode, Integer> dec, Map<TreeNode, Integer> rightDec){
        if(root == null){
            return;
        }

        int leftInc = consecutiveInc(root.left, ans, root.val+1, inr, rightInr);
        int leftDec = consecutiveDec(root.left, ans, root.val-1, dec, rightDec);

        int rightInc = consecutiveInc(root.right, ans, root.val+1, inr, rightInr);
        int right = consecutiveDec(root.right, ans, root.val-1, dec, rightDec);

        int curr = Math.max(leftInc+right+1, leftDec+rightInc+1);
        ans[0] = Math.max(ans[0], curr);

        solve(root.left, ans, inr, rightInr, dec, rightDec);
        solve(root.right, ans, inr, rightInr, dec, rightDec);
    }

    private int consecutiveInc(TreeNode node, int[] ans, int exp, Map<TreeNode, Integer> inr, Map<TreeNode, Integer> rightInr){
        if(node == null){
            return 0;
        }
        if(node.val != exp){
            return 0;
        }

        int leftInc = 0;

        if(inr.containsKey(node)){
            leftInc = inr.get(node);
        }else{
            leftInc = consecutiveInc(node.left, ans, node.val+1, inr, rightInr);
            inr.put(node, leftInc);
        }

        int rightInc = 0;

        if(rightInr.containsKey(node)){
            rightInc = rightInr.get(node);
        }else{
            rightInc = consecutiveInc(node.right, ans, node.val+1, inr, rightInr);
            rightInr.put(node, rightInc);
        }

        return 1+Math.max(leftInc, rightInc);
    }

    private int consecutiveDec(TreeNode node, int[] ans, int exp, Map<TreeNode, Integer> dec , Map<TreeNode, Integer> rightDec){
        if(node == null){
            return 0;
        }

        if(node.val != exp){
            return 0;
        }

        int left = 0;

        if(dec.containsKey(node)){
            left = dec.get(node);
        }else{
            left = consecutiveDec(node.left, ans, node.val-1, dec, rightDec);
            dec.put(node, left);
        }

        int right = 0;

        if(rightDec.containsKey(node)){
            right = rightDec.get(node);
        }else{
            right = consecutiveDec(node.right, ans, node.val-1, dec, rightDec);
            dec.put(node, right);
        }

        return 1+Math.max(left, right);
    }
}
