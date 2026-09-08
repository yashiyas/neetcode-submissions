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
    public List<List<Integer>> findLeaves(TreeNode root) {

        Map<TreeNode, Integer> heightMap = new HashMap();

        List<List<Integer>> ans = new ArrayList();

        int height = getHeight(heightMap,root);

        heightMap.put(root, height);

        Map<Integer, List<Integer>> heightNodes = new TreeMap();

        for(Map.Entry<TreeNode,Integer> entry: heightMap.entrySet()){
            TreeNode node = entry.getKey();
            int currH = entry.getValue();

            heightNodes.computeIfAbsent(currH, k-> new ArrayList());
            heightNodes.get(currH).add(node.val);
        }

        for(Map.Entry<Integer, List<Integer>> entry: heightNodes.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
        
    }

    private int getHeight(Map<TreeNode, Integer> heightMap, TreeNode node){
        if(node == null){
            return 0;
        }

        if(heightMap.containsKey(node)){
            return heightMap.get(node);
        }

        int height = 1 + Math.max(getHeight(heightMap, node.left), getHeight(heightMap, node.right));

        heightMap.put(node, height);

        return height;
    }
}
