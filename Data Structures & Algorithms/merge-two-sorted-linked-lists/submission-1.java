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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp = null;
        while(list1!=null&&list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            int val = 0;
            if(val1<val2){
                val = val1;
                list1 = list1.next;
            }else{
                val = val2;
                list2 = list2.next;
            }
            if(head == null){
                head = new ListNode(val);
                temp = head;
            }else{
                while(temp.next!=null)
                    temp = temp.next;
                temp.next = new ListNode(val);
                temp = temp.next;
            }
        }
        while(list1!=null){
            if(head == null){
                head = new ListNode(list1.val);
                temp = head;
            }else{
                while(temp.next!=null)
                    temp = temp.next;
                temp.next = new ListNode(list1.val);
                temp = temp.next;
            }
            list1 = list1.next;
        }
        while(list2!=null){
            if(head == null){
                head = new ListNode(list2.val);
                temp = head;
            }else{
                while(temp.next!=null)
                    temp = temp.next;
                temp.next = new ListNode(list2.val);
                temp = temp.next;
            }
            list2 = list2.next;
        }
        return head;

    }
}