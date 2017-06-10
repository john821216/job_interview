package Leetcode;

import java.util.Arrays;

public class _575 {
	public int distributeCandies(int[] candies) {
		Arrays.sort(candies);
		int cur = candies[0];
		int count = 1;
		for (int i = 0; i < candies.length - 1; i++) {
			if (candies[i + 1] != cur) {
				count++;
				cur = candies[i + 1];
			}
		}

		if (count >= candies.length / 2) {
			return candies.length / 2;
		} else {
			return count;
		}
	}
}
