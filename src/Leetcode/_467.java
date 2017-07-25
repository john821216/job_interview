package Leetcode;

import java.util.HashSet;

public class _467 {
	public static void main(String[] args) {
		_467 a = new _467();
		a.execute();
	}

	public void execute() {
		System.out.println(findSubstringInWraproundString2("zaba"));
	}

	public int findSubstringInWraproundString(String p) {
		HashSet<String> h = new HashSet<String>();
		int count = 0;
		for (int i = 0; i < p.length(); i++) {
			for (int j = i + 1; j <= p.length(); j++) {
				if (isValid(p.substring(i, j))) {
					System.out.println(p.substring(i, j));
					if (!h.contains(p.substring(i, j))) {
						h.add(p.substring(i, j));
						count++;
					}
				} else {
					break;
				}
			}
		}
		return count;
	}

	public boolean isValid(String s) {
		for (int i = 1; i < s.length(); i++) {
			if ((s.charAt(i) - s.charAt(i - 1)) != 1 && s.charAt(i) - s.charAt(i - 1) != -25) {
				return false;
			}
		}
		return true;
	}

	public int findSubstringInWraproundString2(String p) {
		int[] count = new int[26];
		int len = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)) {
				len++;
			} else {
				len = 1;
			}
			count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], len);
		}
		int maxCount = 0;
		for (int i = 0; i < 26; i++) {
			maxCount += count[i];
		}
		return maxCount;

	}
}
