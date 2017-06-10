package Leetcode;

public class _459 {

	public static void main(String[] args) {
		_459 a = new _459();
		a.execute();
	}

	public void execute() {
		System.out.println(repeatedSubstringPattern("abacababacab"));
	}

	public boolean repeatedSubstringPattern(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		int cur = gcd(count[0], count[1]);
		for (int i = 2; i < 26; i++) {
			cur = gcd(cur, count[i]);
		}
		return cur != 1;
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			a = a % b;
			int temp = a;
			a = b;
			b = temp;
		}
		return a;
	}
}
