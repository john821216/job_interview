package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _464 {
	public static void main(String[] args) {
		_464 a = new _464();
		a.execute();
	}

	public void execute() {
		System.out.println(canIWin(18, 71));
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		HashMap<String, Boolean> h = new HashMap<String, Boolean>();
		if (desiredTotal <= 0) {
			return true;
		}
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (sum < desiredTotal) {
			return false;
		}
		int[] used = new int[maxChoosableInteger + 1];
		return helper(used, h, desiredTotal);

	}

	public boolean helper(int[] used, HashMap<String, Boolean> h, int desiredTotal) {
		String s = Arrays.toString(used);
		if (h.containsKey(s)) {
			return h.get(s);
		}

		for (int i = 1; i < used.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				if (desiredTotal <= i || !helper(used, h, desiredTotal - i)) {
					h.put(s, true);
					used[i] = 0;
					return true;
				}
				used[i] = 0;
			}
		}
		h.put(s, false);
		return false;
	}
}
