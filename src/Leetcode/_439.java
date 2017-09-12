package Leetcode;

import java.util.Stack;

public class _439 {
	public static void main(String[] args) {
		_439 a = new _439();
		a.execute();
	}
	
	public void execute() {
		System.out.println(parseTernary("F?1:T?4:5"));
	}
	
	public String parseTernary(String expression) {
		Stack<Character> s = new Stack<Character>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (c != ':' && c != '?') {
				s.push(c);
			} else if (c == '?') {
				i--;
				char first = s.pop();
				char second = s.pop();
				if(expression.charAt(i) == 'T') {
					s.push(first);
				} else {
					s.push(second);
				}
			}
			System.out.println(s);
		}
		return s.peek().toString();

	}
}
