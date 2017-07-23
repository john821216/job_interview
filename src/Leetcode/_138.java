package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _138 {

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> h = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = head;
		while (cur != null) {
			h.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}
		
		cur = head;		
		while(cur != null){
			h.get(cur).next = h.get(cur.next);
			h.get(cur).random = h.get(cur.random);
			cur = cur.next;
		}
		return h.get(head);
	}

	private class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}
