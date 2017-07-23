package Leetcode;

import java.util.Arrays;

public class _274 {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		for (int hIndex = citations.length; hIndex >= 1; hIndex--) {
			int rightMostIndex = citations.length - hIndex;
			int leftMostIndex = rightMostIndex - 1;
			if (leftMostIndex == -1) {
				if (citations[rightMostIndex] >= hIndex) {
					return hIndex;
				}
			} else {
				if (citations[rightMostIndex] >= hIndex
						&& citations[leftMostIndex] <= hIndex) {
					return hIndex;
				}
			}
		}
		return 0;
	}
}
