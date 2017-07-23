package Leetcode;

public class _151 {

	public static void main(String[] args) {
		_151 a = new _151();
		a.execute();
	}

	public void execute() {
		System.out.println(reverseWords("a") + "3");
	}

	public String reverseWords(String s) {
		String an = "";
		int i = 0;
		boolean first = false;
		while (i < s.length()) {
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
				int j = i;
				while (j + 1 < s.length() && s.charAt(j + 1) != ' ') {
					j++;
				}
				if (!first) {
					an = s.substring(i, j + 1) + an;
					first = true;
				} else {
					an = s.substring(i, j + 1) + " " + an;
				}
				i = j + 1;

			} else {
				i++;
			}
		}
		return an;
	}
}
