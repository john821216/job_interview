package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23 {
	public static void main(String[] args) {
		_23 a = new _23();
		a.execute();
	}

	public void execute() {
		ListNode[] l = new ListNode[1];
		l[0] = new ListNode(0);
		l[0].next = new ListNode(2);
		l[0].next.next = new ListNode(5);
		mergeKLists(l);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummyNode = new ListNode(0);
		ListNode cur = dummyNode;
		PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				p.add(lists[i]);
			}
		}

		while (!p.isEmpty()) {
			ListNode poll = p.poll();
			cur.next = poll;
			cur = cur.next;
			if (poll.next != null) {
				p.add(poll.next);
			}
		}
		test(dummyNode);
		return dummyNode.next;
	}

	public void test(ListNode c) {
		ListNode cur = c;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

	private class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}

	}
}
