package Leetcode;

public class _593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] numbers = new int[6];
		numbers[0] = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1])
				* (p2[1] - p1[1]);
		numbers[1] = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1])
				* (p3[1] - p1[1]);
		numbers[2] = (p4[0] - p1[0]) * (p4[0] - p1[0]) + (p4[1] - p1[1])
				* (p4[1] - p1[1]);
		numbers[3] = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1])
				* (p3[1] - p2[1]);
		numbers[4] = (p4[0] - p2[0]) * (p4[0] - p2[0]) + (p4[1] - p2[1])
				* (p4[1] - p2[1]);
		numbers[5] = (p4[0] - p3[0]) * (p4[0] - p3[0]) + (p4[1] - p3[1])
				* (p4[1] - p3[1]);

		int count1 = numbers[0];
		int count2 = -1;
		int c1 = 0;
		int c2 = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] != count1) {
				count2 = numbers[i];
				break;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == count1) {
				c1++;
			} else if (numbers[i] == count2) {
				c2++;
			}
		}
		if (!((c1 == 4 && c2 == 2) || (c1 == 2 && c2 == 4))) {
			return false;
		}

		if (c1 > c2) {
			return count1 * 2 == count2;
		} else {
			return count2 * 2 == count1;
		}
	}
}
