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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Create a dummy head to return a new list
        ListNode dummy = new ListNode(0);

        //Create a current pointer to populate the new list
        ListNode curr = dummy;

        //initialise remainder to be 0
        int rem = 0;

        //traverse both the lists until we reach null
        while(l1!=null || l2!=null || rem!=0){
            //get the values at each node
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            //store their sum
            int sum = x+y+rem;
            
            //calculate carry over the value, if any
            rem = sum/10;

            //Create a new node to add to the current list
            curr.next = new ListNode(sum % 10);

            //Repeat with next nodes 
            curr = curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummy.next;
    }
}