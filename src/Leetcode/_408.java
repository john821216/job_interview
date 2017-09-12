package Leetcode;

public class _408 {
	public static void main(String[] args) {
		_408 a = new _408();
		a.execute();
	}

	public void execute() {
		System.out.println(validWordAbbreviation("apple", "a2e"));
	}

	public boolean validWordAbbreviation(String word, String abbr) {
		int wordIdx = 0;
		int abbrIdx = 0;
		while (abbrIdx < abbr.length() && wordIdx < word.length()) {
			if (abbr.charAt(abbrIdx) - 'a' >= 0 && abbr.charAt(abbrIdx) - 'a' < 26) {
				if (abbr.charAt(abbrIdx++) != word.charAt(wordIdx++)) {
					return false;
				}
			} else {
				int n = 0;
				while (abbrIdx < abbr.length()) {
					if (abbr.charAt(abbrIdx) - 'a' >= 0 && abbr.charAt(abbrIdx) - 'a' < 26) {
						break;
					}
					n *= 10;
					n += abbr.charAt(abbrIdx++) - '0';
					if (n == 0) {
						return false;
					}
				}
				wordIdx += n;
			}
		}

		if (abbrIdx == abbr.length() && wordIdx == word.length()) {
			return true;
		}
		return false;
	}
}
