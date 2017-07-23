package Leetcode;

public class _142 {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode l = new ListNode(0);
		l.next = head;
		ListNode slow = l;
		ListNode fast = l;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast != slow)
			return null;

		slow = l;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
