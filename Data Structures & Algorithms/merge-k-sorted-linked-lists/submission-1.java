/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>minHeap = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        for(ListNode list:lists){
            minHeap.add(list);
        }
        ListNode head = null;
        ListNode temp = null;
        while(!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            int val = n.val;
            if(head == null){
                head = new ListNode(val);
                temp = head;
            }else{
                while(temp.next!=null)
                    temp = temp.next;
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            n = n.next;
            if(n!=null)
                minHeap.add(n);
        }
        return head;
    }
}
