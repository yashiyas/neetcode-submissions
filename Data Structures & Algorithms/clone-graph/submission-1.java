/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        Map<Node,Node> nodeMap = new HashMap();

        Node newHead = new Node(1);

        nodeMap.put(node,newHead);

        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        Set<Node> visited = new HashSet();
        visited.add(node);

        while(!queue.isEmpty()){
            Node top = queue.poll();
            if(!nodeMap.containsKey(top)){
                Node newNode = new Node(top.val);
                nodeMap.put(top,newNode);
            }
            for(Node n: top.neighbors){
                if(!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }

        queue.add(node);

        visited = new HashSet();

        visited.add(node);

        while(!queue.isEmpty()){
            Node top = queue.poll();
            Node newNode = nodeMap.get(top);
            List<Node> neighbours = new ArrayList();

            for(Node neigh: top.neighbors){
                Node newNeigh = nodeMap.get(neigh);
                neighbours.add(newNeigh);
                if(!visited.contains(neigh)){
                    visited.add(neigh);
                    queue.offer(neigh);
                }
            }
            newNode.neighbors = neighbours;
        }

        return newHead;

        
        
    }
}