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
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        Map<TreeNode,Integer> heightMap = new HashMap();
        
        ArrayDeque<Pair> aq = new ArrayDeque();

        aq.push(new Pair(root));

        while(!aq.isEmpty()){
            Pair top = aq.pop();

            if(top.visited){

                int lHeight = getHeight(top.node.left, heightMap);
                int rHeight = getHeight(top.node.right, heightMap);

                int currDia = 1+lHeight+rHeight;
                if(currDia > ans){
                    ans = currDia;
                }

            } else{
                top.visited = true;
                aq.push(top);
                if(top.node.left != null){
                    aq.push(new Pair(top.node.left));
                }
                if(top.node.right != null){
                    aq.push(new Pair(top.node.right));
                }
            }
        }

        return ans-1;

        
    }

    private int getHeight(TreeNode node, Map<TreeNode,Integer> heightMap){
        if(node == null){
            return 0;
        }

        if(heightMap.containsKey(node)){
            return heightMap.get(node);
        }

        int lHeight = getHeight(node.left, heightMap);
        int rHeight = getHeight(node.right, heightMap);

        int height = 1+Math.max(lHeight, rHeight);

        heightMap.put(node, height);

        return height;
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
