package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _306 {
	public static void main(String[] args) {
		_306 a = new _306();
		a.execute();
	}

	public void execute() {
		System.out.println(isAdditiveNumber("111"));
	}

	public boolean isAdditiveNumber(String num) {
		List<String> l = new ArrayList<String>();
		return isAdditiveNumberHelper(l, num, 0);
	}

	public boolean isAdditiveNumberHelper(List<String> l, String num, int start) {
		if (l.size() > 2 && start == num.length()) {
			return true;
		}
		for (int i = start + 1; i <= num.length(); i++) {
			String cur = num.substring(start, i);
			if (cur.length() > 1 && cur.charAt(0) == '0'){
				continue;
			}
			if (l.size() < 2) {
				l.add(cur);
				if (isAdditiveNumberHelper(l, num, i))
					return true;
				l.remove(l.size() - 1);
			} else {
				if (add(l.get(l.size() - 1), l.get(l.size() - 2)).equals(cur)) {
					l.add(cur);
					if (isAdditiveNumberHelper(l, num, i))
						return true;
					l.remove(l.size() - 1);
				} 
			}
		}
		return false;
	}

	public String add(String a, String b) {
		int curA = a.length() - 1;
		int curB = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (curA >= 0 && curB >= 0) {
			int addR = Integer.parseInt(a.charAt(curA--) + "")
					+ Integer.parseInt(b.charAt(curB--) + "") + carry;
			if (addR >= 10) {
				addR -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			sb.insert(0, addR);
		}

		while (curA >= 0) {
			int addR = Integer.parseInt(a.charAt(curA--) + "") + carry;
			if (addR >= 10) {
				addR -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			sb.insert(0, addR);
		}

		while (curB >= 0) {
			int addR = Integer.parseInt(b.charAt(curB--) + "") + carry;
			if (addR >= 10) {
				addR -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			sb.insert(0, addR);
		}

		if (carry == 1) {
			sb.insert(0, 1);
		}
		return sb.toString();
	}
}
