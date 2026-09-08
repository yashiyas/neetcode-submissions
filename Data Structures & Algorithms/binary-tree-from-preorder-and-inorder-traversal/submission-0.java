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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder==null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = indexOf(inorder, preorder[0]);
        int n = preorder.length;
    
        TreeNode leftSub = buildTree(subArray(preorder, 1, mid+1), subArray(inorder,0,mid));
        TreeNode rightSub = buildTree(subArray(preorder, mid+1, preorder.length), subArray(inorder,mid+1,inorder.length));
        root.left = leftSub;
        root.right = rightSub;
        return root;
    }

    public int indexOf(int[] arr, int target){

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int[] subArray(int[] arr, int start, int end) {
        if(start > end){
            return null;
        }
        return Arrays.copyOfRange(arr, start, end);
    }

}
