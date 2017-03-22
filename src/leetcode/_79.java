package leetcode;

public class _79 {
	public static void main(String[] args){
		_79 a = new _79();
		a.execute();
	}
	
	public void execute(){
//		char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F','C','S'} ,{'A', 'D','E','E'}};
		char[][] arr = {{'a'}};
		System.out.println(exist(arr, "a"));
	}
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (isExist(i, j, board, 0, word) == true) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isExist(int x, int y, char[][] board, int wordIndex,
			String word) {
		if (wordIndex == word.length())
			return true;
		if (x > board.length-1 || y > board[0].length-1 || x < 0 || y < 0)
			return false;
		if (board[x][y] == word.charAt(wordIndex)) {
			board[x][y] = '!';
			if (isExist(x + 1, y, board, wordIndex + 1, word)){
//				System.out.println((x+1) + " A" + y + " " + word.charAt(wordIndex));
				return true;
			}
			if (isExist(x - 1, y, board, wordIndex + 1, word)){
//				System.out.println((x-1) + " B" + y);
				return true;
			}
			if (isExist(x, y + 1, board, wordIndex + 1, word)){
//				System.out.println(x + " C" + (y+1));
				return true;
			}
			if (isExist(x, y - 1, board, wordIndex + 1, word)){
//				System.out.println(x + " D" + (y-1));
				return true;
			}
			board[x][y] = word.charAt(wordIndex);
		}
		return false;
	}
}
