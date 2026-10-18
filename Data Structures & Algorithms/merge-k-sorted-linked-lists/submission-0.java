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
        ListNode sec = null;
        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.poll();
            if(head==null){
                head = new ListNode(temp.val);
                sec = head;
            }else{
                while(sec.next!=null)
                    sec = sec.next;
                sec.next = new ListNode(temp.val);
                sec = sec.next;
            }
            temp = temp.next;
            if(temp!=null)
                minHeap.add(temp);
        }
        return head;
    }
}
