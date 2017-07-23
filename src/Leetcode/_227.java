package Leetcode;

import java.util.Stack;

public class _227 {
	public static void main(String[] args) {
		new _227().execute();
	}

	public void execute() {
		System.out.println(calculate("3+2 *5"));
	}

	public int calculate(String s) {
		char sign = '+';
		int curVal = 0;

		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}

			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
				if (sign == '+') {
					st.push(curVal);
				} else if (sign == '-') {
					st.push(-curVal);
				} else if (sign == '*') {
					st.push(st.pop() * curVal);
				} else {
					st.push(st.pop() / curVal);
				}
				sign = s.charAt(i);
				curVal = 0;
			} else {
				curVal = curVal * 10 + s.charAt(i) - '0';
			}
		}
		if (sign == '+') {
			st.push(curVal);
		} else if (sign == '-') {
			st.push(-curVal);
		} else if (sign == '*') {
			st.push(st.pop() * curVal);
		} else {
			st.push(st.pop() / curVal);
		}
		int an = 0;
		for (int i : st) {
			an += i;
		}
		return an;
	}
}
