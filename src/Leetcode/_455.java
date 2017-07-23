package Leetcode;

import java.util.Arrays;

public class _455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int gIdx = 0;
		int sIdx = 0;
		while (gIdx < g.length && sIdx < s.length) {
			if (g[gIdx] <= s[sIdx]) {
				gIdx++;
				sIdx++;
				count++;
			} else if (g[gIdx] > s[sIdx]) {
				sIdx++;
			}
		}
		return count;
	}
}
