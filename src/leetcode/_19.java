package Leetcode;

public class _19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode l = new ListNode(0);
		ListNode slow = l;
		ListNode fast = l;
		slow.next = head;
		for (int i = 0; i < n + 1; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
