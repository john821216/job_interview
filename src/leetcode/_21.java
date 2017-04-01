package leetcode;

public class _21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		while (l1 != null) {
			cur.next = l1;
			cur = cur.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			cur.next = l2;
			cur = cur.next;
			l2 = l2.next;
		}
		return head.next;
	}
}
