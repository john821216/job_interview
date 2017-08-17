package Leetcode;

public class _481 {
	public static void main(String[] args) {
		new _481().magicalString(9);
	}

	public int magicalString(int n) {
		boolean isOne = true;
		if (n <= 0) {
			return 0;
		}

		if (n <= 3) {
			return 1;
		}
		// 122
		int[] arr = new int[n + 1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 2;
		int head = 3;
		int tail = 4;
		int count = 1;
		while (tail <= n) {
			int nextEle;
			if (isOne) {
				nextEle = 1;
			} else {
				nextEle = 2;
			}
			for (int i = 0; i < arr[head] && tail <= n; i++) {
				arr[tail++] = nextEle;
				if (nextEle == 1) {
					count++;
				}
			}
			isOne = !isOne;
			head++;
		}
		return count;
	}
}
