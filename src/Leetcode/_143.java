package Leetcode;

public class _143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode p1 = slow;
		ListNode p2 = slow.next;
		while (p2.next != null) {
			ListNode n = p2.next;
			p2.next = n.next;
			n.next = p1.next;
			p1.next = n;
		}

		ListNode p3 = head;
		ListNode p4 = slow;
		while (p3 != p4) {
			ListNode p5 = p4.next;
			p4.next = p5.next;
			p5.next = p3.next;
			p3.next = p5;
			p3 = p5.next;

		}
	}

}
