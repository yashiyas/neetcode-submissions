/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {

        Node* newHead = NULL;
        Node* prev = NULL;
        Node* curr = NULL;

        curr = head;
        map<Node*, Node*> nmap;

        while(curr != NULL){
            if(newHead == NULL){
                newHead = new Node(curr->val);
                prev = newHead;
                nmap.insert({curr, newHead});
                curr = curr->next;
            }
            else{
                prev->next = new Node(curr->val);
                nmap.insert({curr, prev->next});
                prev = prev->next;
                curr = curr -> next;
            }
        }

        curr = head;
        while(curr!=NULL){
            if(curr->random !=NULL){
                    Node* random = nmap[curr->random];
                    nmap[curr]->random = random;
            }
            curr = curr->next;
        }
        return newHead;
        
    }
};
