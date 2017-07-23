package Leetcode;

public class _147 {
	public static void main(String[] args){
		_147 a = new _147();
		a.execute();
	}
	
	public void execute(){
		ListNode h = new ListNode(8);
		h.next = new ListNode(7);
		h.next.next = new ListNode(1);
		h.next.next.next = new ListNode(6);
		h.next.next.next.next = new ListNode(5);
		
		ListNode nh = insertionSortList2(h);
		while(nh != null){
			System.out.println(nh.val);
			nh = nh.next;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode s = new ListNode(0);
		s.next = head;

		ListNode cur = s.next;
		while (cur.next != null) {
			ListNode next = cur.next;
			ListNode comp = s;
			while (comp.next.val < next.val && comp.next != next) {
				comp = comp.next;
			}

			if (comp.next == next) {
				cur = cur.next;
				continue;
			}

			ListNode temp = comp.next;
			ListNode temp2 = next.next;
			comp.next = next;
			next.next = temp;
			cur.next = temp2;

		}

		return s.next;
	}
	
	public ListNode insertionSortList2(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode h = new ListNode(0);
		ListNode pre = h;
		ListNode cur;
		ListNode next;
		h.next = head;
		cur = head.next;
		head.next = null;
		
		while(cur != null){
			next = cur.next;
			
			while(pre.next != null && pre.next.val < cur.val){
				pre = pre.next;
			}
			
			cur.next = pre.next;
			pre.next = cur;
			pre = h;
			cur = next;
		}
		return h.next;
	}
}
