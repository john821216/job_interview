package Leetcode;

public class _507 {
	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
	}

	public static boolean checkPerfectNumber(int num) {
		if (num == 0)
			return false;
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				if (num / i != i) {
					sum += num / i;
				}
			}
		}
		return num * 2 == sum;
	}
}
