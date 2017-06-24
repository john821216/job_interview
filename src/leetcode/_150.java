package Leetcode;

import java.util.Stack;

public class _150 {
	public int evalRPN(String[] tokens) {
		Stack<String> s = new Stack<String>();
		int first;
		int second;
		for (String t : tokens) {
			if (t.equals("+")) {
				second = Integer.valueOf(s.pop());
				first = Integer.valueOf(s.pop());
				s.push(first + second + "");
			} else if (t.equals("-")) {
				second = Integer.valueOf(s.pop());
				first = Integer.valueOf(s.pop());
				s.push(first - second + "");
			} else if (t.equals("*")) {
				second = Integer.valueOf(s.pop());
				first = Integer.valueOf(s.pop());
				s.push(first * second + "");
			} else if (t.equals("/")) {
				second = Integer.valueOf(s.pop());
				first = Integer.valueOf(s.pop());
				s.push(first / second + "");
			} else {
				s.push(t);
			}
		}
		return Integer.valueOf(s.pop());
	}
}
