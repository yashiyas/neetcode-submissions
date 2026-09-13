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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder, postorder, 0, n-1, 0, n-1);
        
    }

    private TreeNode build(int[] inorder, int[] postorder, int start1, int end1, int start2, int end2){
        if(start1 < 0 || start2 < 0 || start1 > end1 || start2 > end2){
            return null;
        }

        TreeNode node = new TreeNode(postorder[end2]);

        int mid = getIndex(inorder, postorder[end2]);

        int rightNums = end1 - mid;

        node.right = build(inorder, postorder, mid+1, end1, end2 - (rightNums) ,end2-1);
        node.left = build(inorder, postorder, start1, mid-1, start2,end2 - (rightNums) -1);

        return node;


    }

    private int getIndex(int[] inorder, int val){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == val){
                return i;
            }
        }

        return -1;
    }
}