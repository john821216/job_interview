package Leetcode;

public class _374 {
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int curGuess = guess(mid);
			if (curGuess == 1) {
				low = mid + 1;
			} else if (curGuess == -1) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	public int guess(int n) {
		return 0;
	}
}
