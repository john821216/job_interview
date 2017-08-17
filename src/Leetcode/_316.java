package Leetcode;

public class _316 {

	public static void main(String[] args) {
		_316 a = new _316();
		a.execute();
	}

	public void execute() {
		System.out.println(removeDuplicateLetters("bccacbaaaaac"));
	}

	public String removeDuplicateLetters(String s) {
		if (s.length() == 0) {
			return "";
		}
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}

			int curCIdx = s.charAt(i) - 'a';
			count[curCIdx]--;
			if (count[curCIdx] == 0) {
				break;
			}
		}
		String nextStr = removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
		return s.charAt(pos) + nextStr;
	}
}
