/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int diameter = 0;

    public int diameter(Node root) {

        solve(root);

        return diameter;
        
    }

    private int solve(Node node){
        if(node == null){
            return 0;
        }

        int longest = 0;
        int secondLongest = 0;

        for(Node child: node.children){
            int curr = solve(child);
            if(curr > longest){
                secondLongest = longest;
                longest = curr;
            }else if(curr > secondLongest){
                secondLongest = curr;
            }
        }

        int currDia = longest+secondLongest;
        diameter = Math.max(diameter, currDia);
        return 1+longest;
    }
}
