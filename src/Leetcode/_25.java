package Leetcode;

public class _25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummyNode = new ListNode(0);
		ListNode pre = dummyNode;
		ListNode cur = head;
		ListNode next;

		dummyNode.next = head;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}

		while (count >= k) {
			cur = pre.next;
			next = cur.next;

			for (int i = 1; i < k; i++) {
				ListNode temp = next.next;
				next.next = pre.next;
				pre.next = next;
				cur.next = temp;
				next = temp;
			}
			pre = cur;
			count -= k;
		}
		return dummyNode.next;

	}
}
