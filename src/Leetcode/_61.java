package Leetcode;

public class _61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode sizeL = head;
		ListNode cur = head;
		int size = 1;

		while (sizeL.next != null) {
			sizeL = sizeL.next;
			size++;
		}
		k %= size;
		sizeL.next = head;

		for (int i = 0; i < size - k - 1; i++) {
			cur = cur.next;
		}

		ListNode newH = cur.next;
		cur.next = null;
		return newH;
	}
}
