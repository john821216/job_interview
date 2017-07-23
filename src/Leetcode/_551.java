package Leetcode;

public class _551 {
	public boolean checkRecord(String s) {
		int l = 0;
		int a = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'L')
				l++;
			else
				l = 0;
			if (c == 'A')
				a++;
			if (a > 1 || l > 2)
				return false;
		}
		return true;
	}
}
