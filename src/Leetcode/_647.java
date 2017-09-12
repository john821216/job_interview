package Leetcode;

public class _647 {
	public static void main(String[] args) {
		_647 a = new _647();
		a.execute();
	}
	
	public void execute() {
		countSubstrings("aaa");
	}
	
	
	public int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += extendPalidrome(s, i, i);
			count += extendPalidrome(s, i, i + 1);
		}
		return count;
	}

	public int extendPalidrome(String s, int left, int right) {
		int count = 0;
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
}
