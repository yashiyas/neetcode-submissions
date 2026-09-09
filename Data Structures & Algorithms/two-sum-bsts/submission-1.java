/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *     this.val = val;
 * }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();

        inorderTrav(root1,inorder1);
        inorderTrav(root2,inorder2);

        int i = 0;
        int j = inorder2.size() - 1;

        while(i < inorder1.size() && j >= 0){
            long curr = (long) inorder1.get(i) + inorder2.get(j);

            if(curr == target){
                return true;
            }
            if(curr < target){
                i++;
            } else {
                j--;
            }
        }

        return false;

        
    }

    private void inorderTrav(TreeNode node, List<Integer> inorder){

        if(node == null){
            return;
        }

        inorderTrav(node.left, inorder);
        inorder.add(node.val);
        inorderTrav(node.right, inorder);

    }
}