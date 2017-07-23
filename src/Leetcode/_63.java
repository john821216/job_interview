package Leetcode;

public class _63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] count = new int[obstacleGrid.length][obstacleGrid[0].length];
		if(obstacleGrid[0][0] == 1) return 0;
		count[0][0] = 1;
		for (int i = 1; i < obstacleGrid[0].length; i++) {
			if (obstacleGrid[0][i] == 0) {
				if (count[0][i - 1] == 1) {
					count[0][i] = 1;
				} else {
					count[0][i] = 0;
				}
			}
		}

		for (int i = 1; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 0) {
				if (count[i - 1][0] == 1) {
					count[i][0] = 1;
				} else {
					count[i][0] = 0;
				}
			}
		}
		
		for(int i = 1 ; i < obstacleGrid.length ; i++){
			for(int j = 1; j < obstacleGrid[0].length; j++){
				if(obstacleGrid[i][j] == 0){
					count[i][j] = count[i-1][j] + count[i][j-1];
				}
			}
		}
		return count[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
}
