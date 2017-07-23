package Leetcode;

import java.util.Stack;

public class _232_2 {
	Stack<Integer> input;
	Stack<Integer> output;

	/** Initialize your data structure here. */
	public _232_2() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		peek();
		return output.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(output.isEmpty()){
			while(!input.isEmpty()){
				output.push(input.pop());
			}
		}
		return output.peek();
	}
	
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}
