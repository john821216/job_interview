package Leetcode;

public class _466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int[] repeatCount = new int[n1 + 1];
		int[] nextIdx = new int[n1 + 1];
		int j = 0;
		int rCount = 0;
		for (int i = 1; i <= n1; i++) {
			for (int s1Idx = 0; s1Idx < s1.length(); s1Idx++) {
				if (s1.charAt(s1Idx) == s2.charAt(j)) {
					j++;
					if (j == s2.length()) {
						j = 0;
						rCount++;
					}
				}
			}
			repeatCount[i] = rCount;
			nextIdx[i] = j;

			for (int start = 1; start < i; start++) {
				if (nextIdx[start] == j) {
					int pre = repeatCount[start];
					int rep = (repeatCount[i] - repeatCount[start])
							* (n1 - start) / (i - start);
					int rest = repeatCount[start + (n1 - start) % (i - start)]
							- repeatCount[start];
					return (pre+rep+rest) / n2;
				}
			}
		}
		return repeatCount[n1]/n2;
	}
}
