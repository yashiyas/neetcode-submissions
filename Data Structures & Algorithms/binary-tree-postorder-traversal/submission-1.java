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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList();

        if(root == null){
            return ans;
        }

        Set<TreeNode> visited = new HashSet();

        ArrayDeque<TreeNode> stack = new ArrayDeque();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.pop();

            if(top.left == null && top.right == null){
                ans.add(top.val);
                visited.add(top);
                continue;
            }

            if(top.left != null && !visited.contains(top.left)){
                stack.push(top);
                stack.push(top.left);
                continue;
            }

            if(top.right != null && !visited.contains(top.right)){
                stack.push(top);
                stack.push(top.right);
                continue;
            }

            ans.add(top.val);
            visited.add(top);
        }

        return ans;
        
    }
}