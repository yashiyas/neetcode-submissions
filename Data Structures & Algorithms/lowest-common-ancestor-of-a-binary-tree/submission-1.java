/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, Boolean> presentP = new HashMap();
        Map<TreeNode, Boolean> presentQ = new HashMap();

        TreeNode curr = root;

        while(curr != null){
            if(curr == p || curr == q){
                return curr;
            }

            if((isPresent(curr.left, p, presentP) && isPresent(curr.right, q, presentQ)) || (isPresent(curr.left, q, presentQ) && isPresent(curr.right, p, presentP))){

                return curr;
            }

            if(isPresent(curr.left, p, presentP) && isPresent(curr.left, q, presentQ)){
                curr = curr.left;
            }

            if(isPresent(curr.right, p, presentP) && isPresent(curr.right, q, presentQ)){
                curr = curr.right;
            }
        }

        return curr;
        
    }

    private boolean isPresent(TreeNode curr, TreeNode p, Map<TreeNode, Boolean> presentMap){
        if(curr == null){
            return false;
        }

        if(curr == p){
            return true;
        }

        if(presentMap.containsKey(curr)){
            return presentMap.get(curr);
        }

        Boolean ans = isPresent(curr.left, p, presentMap) || isPresent(curr.right, p, presentMap);
        presentMap.put(curr, ans);
        return ans;
    }
}