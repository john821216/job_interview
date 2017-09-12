package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class _604 {

	public static void main(String[] args) {
		_604 a = new _604("L1e2t1C1o1d1e1");
		a.execute();
	}

	public void execute() {
		System.out.print(next());
	}

	LinkedList<String[]> l;

	public _604(String compressedString) {
		l = new LinkedList<String[]>();
		int idx = 0;
		while (idx < compressedString.length()) {
			char c = compressedString.charAt(idx++);
			String number = "";
			while (idx < compressedString.length() && compressedString.charAt(idx) - '0' >= 0
					&& compressedString.charAt(idx) - '0' <= 9) {
				number += compressedString.charAt(idx);
				idx++;
			}
			String[] s = new String[2];
			s[0] = c + "";
			s[1] = number;
			l.add(s);
		}
	}

	public char next() {
		if (!hasNext()) {
			return ' ';
		}

		String[] f = l.getFirst();
		String s = f[0];
		String time = f[1];
		if (Integer.parseInt(time) == 1) {
			l.removeFirst();
		} else {
			f[1] = Integer.parseInt(time) - 1 + "";
		}
		return s.toCharArray()[0];
	}

	public boolean hasNext() {
		return l.size() != 0;
	}
}
