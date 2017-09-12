package Leetcode;

import java.util.HashMap;

public class _418 {

	public static void main(String[] args) {
		_418 a = new _418();
		a.execute();
	}

	public void execute() {
		System.out.println(wordsTyping(new String[] { "f", "p", "a" }, 8, 7));
	}

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int count = 0;
		int curRow = 0;
		int curCol = 0;
		int senIdx = 0;
		while (curRow < rows && curCol < cols) {
			if (curCol + sentence[senIdx].length() - 1 < cols) {
				if (senIdx + 1 == sentence.length) {
					count++;
				}
				curCol += sentence[senIdx].length();
				senIdx = (senIdx + 1) % sentence.length;
				if (curCol + 1 < cols) {
					curCol = curCol + 1;
				} else {
					curCol = 0;
					curRow++;
				}
			} else {
				curCol = 0;
				curRow++;
			}
		}
		return count;
	}
}
