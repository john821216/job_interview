package Leetcode;

public class _231 {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n != 1) {
			if (n % 2 == 1) {
				return false;
			}
			n /= 2;
		}
		return true;
	}
	
	public boolean isPowerOfTwo2(int n) {
		if( n <= 0 ) return false;
		return (n&(n-1)) == 0;
	}

}
