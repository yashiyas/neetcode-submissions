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

        List<Node> pNodes = new ArrayList();
        List<Node> qNodes = new ArrayList();

        buildNodes(p, pNodes);
        buildNodes(q, qNodes);

        int n1 = pNodes.size() -1;
        int n2 = qNodes.size() -1;

        Node ans = null;

        while(n1 >=0 && n2>=0){

            if(pNodes.get(n1) != qNodes.get(n2)){
                return ans;
            }

            ans = pNodes.get(n1);
            n1--;
            n2--;

        }
        return ans;
        
    }

    private void buildNodes(Node p, List<Node> pNodes){

        while(p != null){
            pNodes.add(p);
            p=p.parent;
        }

    }
}