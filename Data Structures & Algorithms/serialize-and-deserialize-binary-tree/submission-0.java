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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null){
            return "N";
        }

        String ans = String.valueOf(root.val)+","+serialize(root.left)+","+serialize(root.right);
        return ans;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("N")){
            return null;
        }
        ArrayDeque<TreeNode> aq = new ArrayDeque();
        String [] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        TreeNode curr = root;
        int i=1;
        while(i < arr.length){
            if(curr != null){
                aq.push(curr);
                String val = arr[i];

                if(!val.equals("N")){
                    TreeNode temp = new TreeNode(Integer.valueOf(val));
                    curr.left = temp;
                }
                
                curr = curr.left;
                i++;
            } else {
                TreeNode prev = aq.pop();
                String val = arr[i];
                
                if(!val.equals("N")){
                    TreeNode temp = new TreeNode(Integer.valueOf(val));
                    prev.right = temp;
                }
              
                curr = prev.right;
                i++;
            }
        }
        return root;
    }
}
