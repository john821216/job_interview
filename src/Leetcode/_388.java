package Leetcode;

import java.util.Stack;

public class _388 {

	public static void main(String[] args) {
		_388 a = new _388();
		a.execute();
	}

	public void execute() {
		// a\n\tb.txt\na2\n\tb2.txt
		lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt");
	}

	public static int lengthLongestPath(String input) {
		Stack<Integer> s = new Stack<Integer>();
		String[] split = input.split("\n");
		int maxLen = 0;
		for (String sp : split) {
			int level = sp.lastIndexOf("\t") + 1;
			if (level == 0) {
				while (!s.isEmpty()) {
					s.pop();
				}
				s.push(sp.length());
				if (sp.contains(".")) {
					maxLen = sp.length();
				}
			} else {
				while (level < s.size()) {
					s.pop();
				}
				int curLen = s.peek() + sp.length() - level + 1;
				s.push(curLen);
				if (sp.contains(".")) {
					maxLen = Math.max(curLen, maxLen);
					System.out.println(maxLen);
				}
			}
		}
		return maxLen;
	}
}
