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
        //creating a dummy node to initialize head for traversal of return
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        
        //merging
        while(list1!=null && list2!=null){
        if(list1.val<list2.val){
            head.next = list1;
            list1 = list1.next;
        }else{
            head.next = list2;
            list2 = list2.next;
        }
        head = head.next;
        }
        //if one of the lists reaches null first merge the remaining list
        if(list1!=null){
            head.next=list1;
        }else{
            head.next=list2;
        }
        return dummy.next;
    }
}