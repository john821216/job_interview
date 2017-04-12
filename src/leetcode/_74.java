package Leetcode;

public class _74 {
	public static void main(String[] args){
		_74 a = new _74();
		a.execute();
	}
	
	public void execute(){
		int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(m,16));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0;
		int high = m*n-1;
		while (low <= high) {
			int mid = low + (high-low) / 2; 
			System.out.println(mid/n +" " + mid%n);
			if(matrix[mid/n][mid%n] > target){
				high = mid - 1;
			} else if(matrix[mid/n][mid%n] < target){ 
				low = mid + 1;
			} else{
				return true;
			}
		}
		return false;			
	}
}
