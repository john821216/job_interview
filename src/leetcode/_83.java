package leetcode;

public class _83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		int curVal = head.val;
		ListNode newHead = new ListNode(head.val);
		ListNode curNode = newHead;

		while (head.next != null) {
			int nextVal = head.next.val;
			if (nextVal != curVal) {
				curVal = nextVal;
				curNode.next = new ListNode(nextVal);
				curNode = curNode.next;
			}
			head = head.next;
		}
		return newHead;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null) return head;
		head.next = deleteDuplicates2(head.next);
		if(head.val == head.next.val){
			return head.next;
		} else{
			return head;
		}
	}
}
