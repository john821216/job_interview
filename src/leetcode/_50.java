package leetcode;

public class _50 {
	public static void main(String[] args) {
		_50 a = new _50();
		a.execute();
	}

	public void execute() {
		System.out.println(myPow(3,-3));
		
	}

	public double myPow(double x, int n) {
		if (n == 0){
			return 1;
		}
		if (n == Integer.MIN_VALUE) {
			return 1 / x * myPow(x, n + 1);
		}
		if (n < 0) {
			n = -n;
			return 1 / myPow(x, n);
		}
		if (n % 2 == 0) {
			double cur = myPow(x, n / 2);
			return cur * cur;
		} else {
			return x * myPow(x, n - 1);
		}
	}
}
