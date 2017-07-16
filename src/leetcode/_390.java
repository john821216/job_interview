package Leetcode;

public class _390 {
	public int lastRemaining(int n) {
		boolean isLeft = true;
		int step = 1;
		int head = 1;
		int remaining = n;
		while (remaining != 1) {
			if (isLeft) {
				head += step;
			} else {
				if (remaining % 2 == 1) {
					head += step;
				}
			}
			remaining /= 2;
			step *= 2;
			isLeft = !isLeft;
		}
		return head;
	}
}
