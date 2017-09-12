package Leetcode;

import java.util.HashMap;

public class _146 {
	int count = 0;
	int capacity;
	private DLinkedList head;
	private DLinkedList tail;
	private HashMap<Integer, DLinkedList> h;

	public _146(int capacity) {
		head = new DLinkedList();
		tail = new DLinkedList();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
		h = new HashMap<Integer, DLinkedList>();
	}

	public int get(int key) {
		if (!h.containsKey(key)) {
			return -1;
		}
		DLinkedList get = h.get(key);
		delete(get);
		add(get);
		return get.val;
	}

	public void put(int key, int value) {
		DLinkedList newNode = new DLinkedList();
		newNode.key = key;
		newNode.val = value;
		if (!h.containsKey(key)) {
			h.put(key, newNode);
			count++;
			if (count > capacity) {
				DLinkedList removeNode = removeFromTail();
				h.remove(removeNode.key);
				count--;
			}
			add(newNode);
		} else {
			delete(h.get(key));
			add(newNode);
			h.put(key, newNode);
		}
	}

	public void add(DLinkedList node) {
		node.next = head.next;
		head.next = node;

		node.next.pre = node;
		node.pre = head;
	}

	public void delete(DLinkedList node) {
		DLinkedList pre = node.pre;
		DLinkedList next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	public DLinkedList removeFromTail() {
		DLinkedList pre = tail.pre;
		delete(pre);
		return pre;
	}

	private class DLinkedList {
		int key;
		int val;
		DLinkedList pre;
		DLinkedList next;
	}
}
