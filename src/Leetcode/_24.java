package Leetcode;

public class _24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode f = head;
		ListNode s = head.next;
		ListNode newHead = s;
		while (s.next != null && s.next.next != null) {
			ListNode n = s.next;
			s.next = f;
			f.next = n.next;

			f = n;
			s = n.next;
		}
		ListNode n = s.next;
		s.next = f;
		f.next = n;
		return newHead;
	}
	
	public ListNode swapPairs2(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode l = new ListNode(0);
		l.next = head;
		ListNode cur = l;
		while(cur.next != null && cur.next.next != null){
			ListNode first = cur.next;
			ListNode second = cur.next.next;
			cur.next = second;
			first.next = second.next;
			second.next = first;
			cur = first;
		}
		return l.next;	
	}
}
