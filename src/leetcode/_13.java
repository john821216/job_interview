package Leetcode;

public class _13 {
	public int romanToInt(String s) {
		int cur = -1;
		int val = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int curV = getValue(s.charAt(i));
			if (curV >= cur) {
				val += curV;
			} else {
				val -= curV;
			}
			cur = curV;
		}
		return val;
	}

	public int getValue(char c) {

		// Symbol I V X L C D M
		// Value 1 5 10 50 100 500 1,000

		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else {
			return 1000;
		}
	}
}
