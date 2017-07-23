package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22 {

	public static void main(String[] args) {
		_22 a = new _22();
		a.execute();
	}

	public void execute() {
		generateParenthesis(3);
	}

	public List<String> generateParenthesis(int n) {
		List<String> l = new ArrayList<String>();
		generateHelper(l, "", n, 0, 0 );
		return l;
	}

	public void generateHelper(List<String> l, String s, int n, int left,
			int right) {
		if (n == left && n == right) {
			l.add(s);
		}

		else if (left <= n && right <= n && left >= right) {

			generateHelper(l, s+"(", n, left + 1, right);
			generateHelper(l, s+")", n, left , right+1);

		}
	}
}
