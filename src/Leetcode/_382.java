package Leetcode;

import java.util.Random;

public class _382 {
	// Reservoir Sampling
	ListNode h;

	public _382(ListNode head) {
		h = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int count = 0;
		ListNode cur = h;
		int an = cur.val;
		while (cur != null) {
			int r = new Random().nextInt(count + 1);
			if (r == count) {
				an = cur.val;
			}
			count++;
			cur = cur.next;
		}
		return an;
	}
}
