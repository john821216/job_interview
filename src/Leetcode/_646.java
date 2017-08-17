package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _646 {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new pairsComparator());
		int sum = 1;
		int idx = 1;
		int end = pairs[0][1];
		while(idx < pairs.length) {
			if(end < pairs[idx][0]) {
				sum++;
				end = pairs[idx][1];
			} else {
				idx++;
			}
		}
		return sum;
	}

	private class pairsComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[1] - o2[1];
		}

	}
}
