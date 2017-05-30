package Leetcode;

import java.util.Arrays;

public class _279 {
	
	public static void main(String[] args){
		_279 a = new _279();
		a.execute();
	}
	
	public void execute(){
		System.out.println(numSquares(12));
		
	}
	public int numSquares(int n) {
		int[] arr = new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		for(int i = 1 ; i <=n ; i++){
			int j = 1;
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			while(i-j*j>=0){
				if(min > arr[i-j*j]){
					min = arr[i-j*j];
					minIdx = i-j*j;
				}
				j++;
			}
			arr[i] = arr[minIdx]+1;
		}
		return arr[n];
	}
}
