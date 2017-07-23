package Leetcode;

public class _289 {
	public void gameOfLife(int[][] board) {
    		int m = board.length; 
    		int n = board[0].length;
    		//4 states
    		// next cur
    		// 0    0
    		// 0    1
    		// 1    0
    		// 1    1
    		// we need to consider 01->11 and 00->10    		
 
    		
    		for(int i = 0 ; i < m ; i++){
    			for(int j = 0 ; j < n ; j++){
    				int lives = getLive(board,m,n,i,j);
    				//01->11
    				if(board[i][j] == 1 && (lives ==2 || lives == 3)){
    					board[i][j] = 3;
    				} else if(board[i][j] == 0 && lives ==3 ){
    					board[i][j] = 2;
    				}
    			}
    		}
    		
    		for(int i = 0 ; i < m ; i++){
    			for(int j =0 ; j < n ; j++){
    				board[i][j] /=2 ;
    			}
    		}
    }

	public int getLive(int[][] board, int m, int n, int i, int j) {
		int count = 0;
		for (int a = Math.max(i - 1, 0); a <= Math.min(i + 1, m - 1); a++) {
			for (int b = Math.max(0, j - 1); b <= Math.min(n - 1, j + 1); b++) {
				if (board[a][b] % 2 == 1) {
					count++;
				}
			}
		}
		if (board[i][j] % 2 == 1) {
			count--;
		}
		return count;
	}
}
