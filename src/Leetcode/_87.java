package Leetcode;

public class _87 {
	// https://discuss.leetcode.com/topic/36715/simple-iterative-dp-java-solution-with-explanation
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		int len = s1.length();
		boolean[][][] f = new boolean[len][len][len + 1];

		for (int l = 1; l <= len; l++) {
			for (int i = 0; i + l - 1 < len; i++) {
				for (int j = 0; j + l - 1 < len; j++) {
					if (l == 1) {
						if (s1.charAt(i) == s2.charAt(j)) {
							f[i][j][l] = true;
						}
					} else {
						for (int q = 1; q < l; q++) {
							f[i][j][l] = (f[i][j][q] && f[i + q][j + q][l - q])
									|| (f[i][j + l - q][q] && f[i + q][j][l-q]);
							if(f[i][j][l]) {
								break;
							}
						}
					}
				}
			}
		}
		return f[0][0][len];
	}
}
