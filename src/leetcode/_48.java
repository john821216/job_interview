package leetcode;

public class _48 {
	
	public static void main(String[] args){
		_48 a = new _48();
		a.execute();
		
	}
	
	public void execute(){
		int[][] m = {{1,2,3,4},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		rotate(m);
	}
	public void rotate(int[][] matrix) {
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < i ; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0 ; j < matrix.length/2 ; j++){
				int temp = matrix[i][matrix.length-1-j];
				matrix[i][matrix.length-1-j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
		
		
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix.length ; j++){
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
	}

}
