package Leetcode;

import java.util.Stack;

public class _232 {
	Stack<Integer> s;

	/** Initialize your data structure here. */
	public _232() {
		s = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!s.isEmpty()) {
			temp.add(s.pop());
		}
		s.add(x);
		while (!temp.isEmpty()) {
			s.add(temp.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return s.pop();
	}

	/** Get the front element. */
	public int peek() {
		return s.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s.isEmpty();
	}
}
