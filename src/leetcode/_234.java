package Leetcode;

public class _234 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode l = new ListNode(0);
		l.next = head;

		ListNode slow = l;
		ListNode fast = l;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// even
		if (fast.next == null) {
			fast = slow.next;
		}
		slow.next = null;

		// reverse fast
		ListNode pre = null;
		ListNode cur = fast;
		while (cur != null) {
			ListNode n = cur.next;
			cur.next = pre;
			pre = cur;
			cur = n;
		}
		cur = pre;
		slow = head;
		System.out.println(cur.val);
		while (slow != null) {
			if (slow.val != cur.val) {
				return false;
			}
			slow = slow.next;
			cur = cur.next;
		}

		return true;
	}

}
