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

        String ans = "";

        if(root == null){
            return "N,";
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode top = queue.poll();
            if(top != null){
                 ans = ans + String.valueOf(top.val)+",";
                 queue.offer(top.left);
                queue.offer(top.right);
            }else{
                ans = ans + "N"+",";
            }

        }

        return ans;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String [] values = data.split(",");

        TreeNode head = getNode(values[0]);
        if(head == null){
            return head;
        }

        int i=1;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(head);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int j=0; j<size; j++){

                TreeNode top = queue.poll();

                top.left = getNode(values[i]);
                top.right = getNode(values[i+1]);

                if(top.left != null){
                    queue.offer(top.left);
                }

                if(top.right != null){
                    queue.offer(top.right);
                }

                i = i+2;

            }


        }

        return head;

        
    }

    private TreeNode getNode(String val){
        if(val.equals("N")){
            return null;
        }

        int value = Integer.valueOf(val);
        return new TreeNode(value);
    }
}
