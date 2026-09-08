/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> nodeMap = new HashMap();

        Node curr = head;
   
        Node prev2 = null;

        Node head2 = null;

        while(curr != null){
            Node newNode = new Node(curr.val);
            if(head2 == null){
                head2 = newNode;
         
            } else{
                prev2.next = newNode;
            }

            nodeMap.put(curr, newNode);
            prev2 = newNode;
            curr = curr.next;
            
        }

        curr = head;

        while(curr != null){
            Node newCurr = nodeMap.get(curr);
            Node random = curr.random;

            if(random != null){
                newCurr.random = nodeMap.get(random);
            }

            curr = curr.next;
        }

        return head2;
        
    }
}
