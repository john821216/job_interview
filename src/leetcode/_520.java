package Leetcode;

public class _520 {
	public boolean detectCapitalUse(String word) {
		char firstC = word.charAt(0);
		boolean isFirstCapital = false;
		boolean isSecondCapital = false;
		boolean ok = true;
		if ((firstC - 'A') < 26) {
			isFirstCapital = true;
		}
		for (int i = 1; i < word.length(); i++) {
			if (isFirstCapital) {
				if (i == 1) {
					if ((word.charAt(i) - 'A') < 26) {
						isSecondCapital = true;
					}
				} else {
					// i>2
					if (isSecondCapital == true) {
						if (word.charAt(i) - 'a' < 26
								&& word.charAt(i) - 'a' >= 0) {
							ok = false;
						}
					} else {
						if (word.charAt(i) - 'A' < 26) {
							ok = false;
						}
					}
				}
			} else {
				if (word.charAt(i) - 'A' < 26 && word.charAt(i) - 'A' >= 0) {
					ok = false;
				}
			}
		}
		return ok;
	}
}
