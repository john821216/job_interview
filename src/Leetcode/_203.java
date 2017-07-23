package Leetcode;

public class _203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode l = new ListNode(0);
		l.next = head;
		ListNode cur = l.next;
		ListNode pre = l;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;

		}
		return l.next;
	}
}
