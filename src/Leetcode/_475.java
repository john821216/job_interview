package Leetcode;

import java.util.Arrays;

public class _475 {
	public static void main(String[] args) {
		_475 a = new _475();
		a.execute();
	}

	public void execute() {
		int[] h = { 2 };
		int[] he = { 2,3,4 };
		findRadius(h, he);
	}

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int rad = 0;
		int j = 0;
		for (int h : houses) {
			int minDis = Integer.MAX_VALUE;
			for (int k = j; k < heaters.length; k++) {
				if (Math.abs(heaters[k] - h) < minDis) {
					minDis = Math.abs(heaters[k] - h);
				}

				if (Math.abs(heaters[k] - h) > minDis) {
					j = k -1;
					break;
				}
			}
			

			rad = Math.max(minDis, rad);
		}
		System.out.println(rad);
		return rad;
	}
}
