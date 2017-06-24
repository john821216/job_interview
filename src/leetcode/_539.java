package Leetcode;

import java.util.Arrays;
import java.util.List;

public class _539 {
	public int findMinDifference(List<String> timePoints) {
		int[] time = new int[timePoints.size()];
		for (int i = 0; i < timePoints.size(); i++) {
			int hour = Integer.parseInt(timePoints.get(i).split(":")[0]);
			int min = Integer.parseInt(timePoints.get(i).split(":")[1]);
			time[i] = 60 * hour + min;
		}
		Arrays.sort(time);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < time.length - 1; i++) {
			if (time[i + 1] - time[i] < min) {
				min = time[i + 1] - time[i];
			}
		}

		min = Math.min(
				Math.min(time[time.length - 1] - time[0], 1440
						- time[time.length - 1] - time[0]), min);
		return min;
	}
}
