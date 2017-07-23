package Leetcode;

public class _86 {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode s = new ListNode(0);
		ListNode g = new ListNode(0);
		ListNode sH = s;
		ListNode gH = g;
		while (head != null) {
			if (head.val < x) {
				s.next = head;
				s = s.next;
			} else {
				g.next = head;
				g = g.next;
			}
			head = head.next;
		}
		g.next = null;// important avoid cycle
		s.next = gH.next;
		return sH.next;

	}
}
