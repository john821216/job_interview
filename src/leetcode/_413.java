package Leetcode;

public class _413 {
	public static void main(String[] args){
		_413 a = new _413();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(arr));
	}
	
	public int numberOfArithmeticSlices(int[] A) {
		int[] dp = new int[A.length];
		int count = 0;
		dp[0] = 0;
		for (int i = 1; i < A.length; i++) {
			dp[i] = A[i] - A[i - 1];
		}
		
		int curCount = 1;
		for (int i = 1; i < A.length; i++) {
			if(dp[i] == dp[i-1]){
				count += curCount;
				curCount++;
			} else{
				curCount = 1;
			}
		}
		return count;
	}
}
