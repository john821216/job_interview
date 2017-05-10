package Leetcode;

public class _378 {
	public static void main(String[] args){
		_378 a = new _378();
		a.execute();
	}
	
	public void execute(){
		int[][] m = {{1,5,9},{10,11,13},{12,13,15}};
		kthSmallest(m,9);
	}
	
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] compare = new int[n];
		int[] m_idx = new int[n];
		// ini
		for (int i = 0; i < n; i++) {
			compare[i] = matrix[i][0];
		}
		
		while(k != 0){
			k--;
			int min = min(compare);
			System.out.println(matrix[min][m_idx[min]] +" " + k);
			if(k == 0) {
				return matrix[min][m_idx[min]];
			}
			m_idx[min]++;
			if(m_idx[min] < n ){
				compare[min] = matrix[min][m_idx[min]];
			} else{
				compare[min] = Integer.MAX_VALUE;
			}
		}
		return -1;

	}

	public int min(int[] nums) {
		int minVal = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (minVal > nums[i]) {
				minIdx = i;
				minVal = nums[i];
			}
		}
		return minIdx;
	}
}
