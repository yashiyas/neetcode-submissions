/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {

        Node currP = p;
        Node currQ = q;

        while(true){
            if(currP == currQ){
                return currP;
            }
            if(currP == null){
                currP = q;
                q = currQ.parent;
                continue;
            }
            if(currQ == null){
                currQ = p;
                p = currP.parent;
                continue;
            }

            currP = currP.parent;
            currQ = currQ.parent;
        }
        
    }
}