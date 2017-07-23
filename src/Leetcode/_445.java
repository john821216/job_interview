package Leetcode;

import java.util.Stack;

public class _445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.add(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.add(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode l = new ListNode(0);

		while (!s1.isEmpty() && !s2.isEmpty()) {
			int val = s1.pop() + s2.pop() + sum;
			ListNode nl = new ListNode(val % 10);
			nl.next = l.next;
			l.next = nl;
			sum = val / 10;
		}

		while (!s1.isEmpty()) {
			int val = s1.pop() + sum;
			ListNode nl = new ListNode(val % 10);
			nl.next = l.next;
			l.next = nl;
			sum = val / 10;
		}

		while (!s2.isEmpty()) {
			int val = s2.pop() + sum;
			ListNode nl = new ListNode(val % 10);
			nl.next = l.next;
			l.next = nl;
			sum = val / 10;
		}
		if (sum != 0) {
			ListNode nl = new ListNode(sum);
			nl.next = l.next;
			l.next = nl;
		}
		return l.next;
	}

}
