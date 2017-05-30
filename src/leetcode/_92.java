package Leetcode;

public class _92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode l = new ListNode(0);
		l.next = head;
		ListNode pre = l;

		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}

        ListNode start = pre.next;
		ListNode next = start.next;
		for (int i = 0; i < n - m; i++) {
			start.next = next.next;
			next.next = pre.next;
			pre.next = next;
			next = start.next;
		}

		return l.next;
	}
}
