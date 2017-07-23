package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _625 {
	HashMap<String, String> h = new HashMap<String, String>();

	public static void main(String[] args) {
		_625 a = new _625();
		a.execute();
	}

	public void execute() {
		System.out.println(smallestFactorization(48));
	}

	public int smallestFactorization(int a) {
		if (a < 10) {
			return a;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 2; i--) {
			while (a % i == 0) {
				sb.append(i);
				a /= i;
			}
		}
		sb = sb.reverse();
		if (a != 1 || compare(sb.toString(), Integer.MAX_VALUE + "") > 0) {
			return 0;
		}
		return Integer.valueOf(sb.toString());
	}

	public int compare(String a, String b) {
		if (a.length() != b.length()) {
			return a.length() - b.length();
		}

		for (int i = 0; i < a.length(); i++) {
			if (Integer.valueOf(a.charAt(i) + "") > Integer.valueOf(b.charAt(i)
					+ "")) {
				return 1;
			} else if (Integer.valueOf(a.charAt(i) + "") < Integer.valueOf(b
					.charAt(i) + "")) {
				return -1;
			}
		}
		return 0;
	}
}
