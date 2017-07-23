package Leetcode;

public class _557 {
	public String reverseWords(String s) {
		String an = "";
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				an = an.equals("") ? an + temp : an + " " + temp;
				temp = "";
			} else {
				temp = s.charAt(i) + temp;
			}
		}

		if (!temp.equals("")) {
			an = an.equals("") ? an + temp : an + " " + temp;
		}
		return an.toString();
	}
}
