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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> ans = new ArrayList();

        if(root == null){
            return ans;
        }

        if(root.left == null && root.right == null){
            ans.add(root.val);
            return ans;
        }

        List<Integer> leftBoundary = new ArrayList();
        List<Integer> rightBoundary = new ArrayList();
        List<Integer> leaves = new ArrayList();

        getLeftBoundary(root.left, leftBoundary);
        getRightBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        getLeaves(root, leaves);

        ans.add(root.val);
        ans.addAll(leftBoundary);
        ans.addAll(leaves);
        ans.addAll(rightBoundary);

        return ans;
        
    }

    private void getLeftBoundary(TreeNode node, List<Integer> leftBoundary){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            return;
        }

        leftBoundary.add(node.val);

        getLeftBoundary(node.left, leftBoundary);

        if(node.left == null){
            getLeftBoundary(node.right, leftBoundary);
        }

    }

    private void getRightBoundary(TreeNode node, List<Integer> rightBoundary){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            return;
        }

        rightBoundary.add(node.val);

        getRightBoundary(node.right, rightBoundary);

        if(node.right == null){
            getRightBoundary(node.left, rightBoundary);
        }

    }

    private void getLeaves(TreeNode node, List<Integer> leaves){
        if(node == null){
            return;
        }

        if(node.left != null){
            getLeaves(node.left, leaves);
        }

        if(node.right != null){
            getLeaves(node.right, leaves);
        }

        if(node.left == null && node.right == null){
            leaves.add(node.val);
        }
    }
}
