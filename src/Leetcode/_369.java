package Leetcode;

public class _369 {
	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode i = dummy;
		ListNode j = dummy;
        dummy.next = head;

		while (j.next != null) {
			j = j.next;
			if (j.val != 9) {
				i = j;
			}
		}

		if (j.val != 9) {
			j.val++;
		} else {
			i.val++;
			i = i.next;
			while (i != null) {
				i.val = 0;
				i = i.next;
			}
		}
		if(dummy.val ==0) {
			return dummy.next;
		}
		return dummy;

	}
}
