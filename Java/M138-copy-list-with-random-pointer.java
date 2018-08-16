/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public HashMap<RandomListNode,RandomListNode> m = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        return traverse(head);
    }
    public RandomListNode traverse(RandomListNode n) {
        if (n == null) {
            return null;
        }
        
        if (m.containsKey(n)) {
            return m.get(n);
        }      
        
        RandomListNode nn = new RandomListNode(n.label);
        m.put(n, nn);
        nn.next = traverse(n.next);
        nn.random = traverse(n.random);
        
        
        return nn;
        
    }
}