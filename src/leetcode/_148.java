package Leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _148{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        		return head;
        }
        
        // length > 2
        ListNode l = new ListNode(0);
        l.next = head;
        ListNode slow = l;
        ListNode fast = l;
        while(fast.next != null && fast.next.next != null){
        		slow = slow.next;
        		fast = fast.next.next;
        }
        
        ListNode r = slow.next;
        slow.next = null;
        
        ListNode fH = sortList(head);
		ListNode rH = sortList(r);
		
		return merge(fH,rH);
    }
    
    public ListNode merge(ListNode l, ListNode r){
    		ListNode sN = new ListNode(0);
    		ListNode h = sN;
    		while(l != null && r != null){
    			if(l.val > r.val){
    				sN.next = r;
    				sN = sN.next;
    				r = r.next;
    			} else{
    				sN.next = l;
    				sN = sN.next;
    				l = l.next;
    			}
    		}
    		
    		if(l != null){
    			sN.next = l;
    			sN = sN.next;
    			l = l.next;
    		}
    		
    		if(r != null){
    			sN.next = r;
    			sN = sN.next;
    			r = r.next;
    		}
    		return h.next;
    }
}