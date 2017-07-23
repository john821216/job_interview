package Leetcode;

public class _488 {
	public static void main(String[] args) {
		_488 a = new _488();
		a.execute();
	}

	public void execute() {
		System.out.println(removeConsecutive("RRRR"));
	}

	public int findMinStep(String board, String hand) {
		int[] handCount = new int[26];
		for (char c : hand.toCharArray()) {
			handCount[c - 'A']++;
		}
		int count = findMinStepHelper(board, handCount);
		if(count == Integer.MAX_VALUE){
			return -1;
		}
		return count;
	}

	public int findMinStepHelper(String board, int[] handCount) {
		int j = 0;
		int count = Integer.MAX_VALUE;
		if (board.equals("")) {
			return 0;
		}
		for (int i = 0; i <= board.length(); i++) {
			if (i < board.length() && board.charAt(i) == board.charAt(j)) {
				continue;
			}
			int consecutiveCount = 3-(i - j);
			if (handCount[board.charAt(j) - 'A'] >= consecutiveCount) {
				handCount[board.charAt(j) - 'A'] -= consecutiveCount;
				int e = findMinStepHelper(
						removeConsecutive(board.substring(0, j)
								+ board.substring(i)), handCount);
				if (e != Integer.MAX_VALUE) {
					count = Math.min(count, e + consecutiveCount);
				}
				handCount[board.charAt(j) - 'A'] += consecutiveCount;
			}
			j = i;
		}
		return count;
	}

	public String removeConsecutive(String board) {
		int j = 0;
		// j i
		// RAAA
		for (int i = 0; i <= board.length(); i++) {
			if (i < board.length() && board.charAt(i) == board.charAt(j)) {
				continue;
			}
			if (i - j >= 3) {
				return removeConsecutive(board.substring(0, j)
						+ board.substring(i));
			} else {
				j = i;
			}
		}
		return board;
	}
}
