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
				if (citations[rightMostIndex] >= hIndex && citations[leftMostIndex] <= hIndex) {
					return hIndex;
				}
			}
		}
		return 0;
	}

	public int hIndex2(int[] citations) {
		int[] stat = new int[citations.length + 1];
		for (int i : citations) {
			if (i >= citations.length) {
				stat[citations.length]++;
			} else {
				stat[i]++;
			}
		}
		int count = 0;
		for (int i = stat.length - 1; i >= 1; i--) {
			count += stat[i];
			if (count >= i) {
				return i;
			}
		}
		return 0;
	}
}
