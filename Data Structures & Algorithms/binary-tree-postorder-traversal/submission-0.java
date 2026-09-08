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

        ArrayDeque<Pair> aq = new ArrayDeque();

        Pair p = new Pair(root);

        aq.push(p);

        while(!aq.isEmpty()){
            Pair curr = aq.pop();
            if(curr.visited){
                ans.add(curr.node.val);
            }
            else{
                curr.visited = true;
                aq.push(curr);
                if(curr.node.right != null){
                    Pair right = new Pair(curr.node.right);
                    aq.push(right);
                }
                if(curr.node.left != null){
                    Pair left = new Pair(curr.node.left);
                    aq.push(left);
                }
            }
        }

        return ans;

        
        
    }

    class Pair {
        TreeNode node;
        Boolean visited;

        Pair(TreeNode node){
            this.node = node;
            this.visited = false;
        }
    }
}