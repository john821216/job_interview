package Leetcode;

public class _334 {
	
	public static void main(String[] args){
		System.out.println((char)(5+'a'));
	}
	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= first)
				first = n;
			if (n > first && n <= second)
				second = n;
			if (n > second)
				return true;
		}
		return false;
	}
}
