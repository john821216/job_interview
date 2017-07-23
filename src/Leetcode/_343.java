package Leetcode;

public class _343 {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int product = 1;
		while (n-3 >= 2) {
			n -= 3;
			product *= 2;
		}
		//2 3 4
		product *= n;
		return product;
	}
}
