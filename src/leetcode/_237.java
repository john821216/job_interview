package Leetcode;

public class _237 {
	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
