package Leetcode;

public class _476 {
	public int findComplement(int num) {
		long perfectS = 1;
		int n = num;
		while (n != 0) {
			n /= 2;
			perfectS *= 2;
		}
		return (int) (perfectS - num - 1);
	}
}
