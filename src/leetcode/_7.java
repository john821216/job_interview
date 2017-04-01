package leetcode;

public class _7 {
	public static void main(String[] args) {
		_7 a = new _7();
		a.execute();
	}

	public void execute() {
		System.out.println(reverse(1534236469));
	}

	public int reverse(int x) {
		int newX = 0;
		while (x != 0) {
			int newResult;
			newResult = newX * 10 + x % 10;
			if((newResult - x%10) / 10 != newX) return 0;
			newX = newResult;
			x /= 10;
		}
		return newX;
	}
}
