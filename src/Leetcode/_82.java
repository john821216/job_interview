package Leetcode;

public class _82 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode l = new ListNode(0);
		l.next = head;
		ListNode pre = l;
		ListNode cur = l.next;

		while (cur != null && cur.next != null) {
			if (cur.val != cur.next.val) {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
			} else {
				int duplicateVal = cur.val;
				while (cur != null && cur.val == duplicateVal) {
					cur = cur.next;
				}
			}
		}

		pre.next = cur;
		return l.next;
	}
}
