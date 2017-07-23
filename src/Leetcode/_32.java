package Leetcode;

import java.util.Stack;

public class _32 {
	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				st.push(i);
			} else {
				if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
					st.pop();
				} else {
					st.push(i);
				}
			}
		}
		if (st.isEmpty()) {
			return s.length();
		}
		int end = s.length();
		int max = 0;
		while (!st.isEmpty()) {
			int from = st.pop();
			max = Math.max(end - from - 1, max);
			end = from;
		}
		max = Math.max(end, max);
		return max;
	}
}
